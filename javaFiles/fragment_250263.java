InputStream in = ...
OutputStrean out = ... // the place you want to ultimately store the file

byte[] buffer = new byte[8192];
int bytesRead;
while ((bytesRead = in.read(buffer)) > 0) {
    out.write(buffer, 0, bytesRead);
}

// close streams.