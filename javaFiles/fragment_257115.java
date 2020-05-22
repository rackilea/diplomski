URL url;//init with your url
byte[] buffer = new byte[1024];
int bufPos;
InputStream is = url.openConnection().getInputStream();
StringBuilder builder = new StringBuilder("");

while((bufPos = is.read(buffer)) != -1)
    builder.append(new String(buffer , 0 , bufPos));

is.close();

return builder.toString();