ChannelExec channel = (ChannelExec) session.openChannel("exec");
channelExec.setCommand("copy run tftp : ");
OutputStream out = channelExec.getOutputStream();
channelExec.connect();
out.write(("192.168.50.1 : \n").getBytes());
out.write(("Config.txt \n").getBytes());
out.flush();