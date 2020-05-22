.....
DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
dos.writeBytes(twoHyphens + boundary + lineEnd);
dos.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + "gold1.jpeg" +"\"" + lineEnd);
dos.writeBytes(lineEnd);
Log.e(Tag,"Headers are written");
.....