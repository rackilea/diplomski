os.write(msgBytes);
os.write("\r\n".getBytes());
os.flush();
// Do something 
os.write("more message");
os.flush();
// When you are finally done
os.close();