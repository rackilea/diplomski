ChannelShell channel = (ChannelShell) session.openChannel("shell"); 

InputStream in = channel.getInputStream(); 
outStream = channel.getOutputStream(); 

channel.setPty(false);
channel.connect(); 

outStream.write('configure\n'.getBytes());  
outStream.write('move shared pre-rulebase security rules TEST top\n'.getBytes());