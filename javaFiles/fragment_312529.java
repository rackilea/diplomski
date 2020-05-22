DefaultExecutor exec = new DefaultExecutor();
PumpStreamHandler streamHandler = new PumpStreamHandler();
exec.setStreamHandler(streamHandler);

CommandLine commandline = CommandLine.parse(command);  //where command is your command line
exec.execute(commandline);