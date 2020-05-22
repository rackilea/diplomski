ServletOutputStream out = response.getOutputStream();
InputStream in = [ code to get source input stream ];
String mimeType = [ code to get mimetype of data to be served ];
int bufferSize = 1024 * 4;
byte[] bytes = new byte[bufferSize];
int bytesRead;

response.setContentType(mimeType);

while ((bytesRead = in.read(bytes)) != -1) {
    long start = System.currentTimeMillis();
    out.write(bytes, 0, bytesRead);
    long stop = System.currentTimeMillis();
    if (stop - start > 700)
    {
        bufferSize /= 2;
        bytes = new byte[bufferSize];
    }
}

// do the following in a finally block:
in.close();
out.close();