response.setContentType("application/pdf");
InputStream in = ... // depends where you store your file 
ServletOutputStream out = response.getOutputStream();
byte[] buffer = new byte[4096];
while(in.read(buffer, 0, 4096) != -1)
   out.write(buffer, 0, 4096);
in.close();
out.flush();
out.close();