InputStream in = new BufferedInputStream( pr.getInputStream());
OutputStream out = new BufferedOutputStream( new FileOutputStream( "output.txt" ));

int cnt;
byte[] buffer = new byte[1024];
while ( (cnt = in.read(buffer)) != -1) {
   out.write(buffer, 0, cnt );
}