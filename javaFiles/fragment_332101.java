public String sendCommand(String command)
{
  StringBuilder outputBuffer = new StringBuilder();

  try
  {
    Channel channel = sesConnection.openChannel("exec");
    ((ChannelExec)channel).setCommand(command);
    channel.connect();
    InputStream commandOutput = channel.getInputStream();

    int readByte = commandOutput.read();
    while(readByte != 0xffffffff)
    {
      outputBuffer.append((char)readByte);
      readByte = commandOutput.read();
      if (interrupt)
      {
        interruptChannel(channel);
        break;
      }
    }

    channel.disconnect();
  }
  catch(IOException ioX)
  {
    logWarning(ioX.getMessage());
    outputBuffer.append(ioX.getMessage());
    return null;
  }
  catch(JSchException jschX)
  {
    logWarning(jschX.getMessage());
    outputBuffer.append(jschX.getMessage());
  }
  finally
  {
    setInterrupt(false);
  }

  return outputBuffer.toString();
}

private void interruptChannel(Channel _channel)
{
  try
  {
    _channel.sendSignal("2");
  }
  catch (Exception e)
  {
    logger.error("Failed interrupting channel", e);
  }
}