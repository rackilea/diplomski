channel.connect();
OutputStream out = channel.getOutputStream();
out.write(("username2\n").getBytes());
out.flush();   
Thread.sleep(1000); 
out.write(("password2\n").getBytes());
out.flush();