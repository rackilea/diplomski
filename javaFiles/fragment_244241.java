int contentLength = (int) responseEntity.getContentLength();
char[] buffer = new char[contentLength];
stream = responseEntity.getContent();
InputStreamReader reader = new InputStreamReader(stream);

int hasRead = 0;
while (hasRead < contentLength)
      hasRead += reader.read(buffer, hasRead, contentLength-hasRead);

stream.close();