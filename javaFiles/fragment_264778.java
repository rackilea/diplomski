if (lineCount == 1 && HTTPMessage.indexOf("HTTP/1.1") != -1) {
                requestedFile = "WebRoot\\"
                        + HTTPMessage.substring(5,
                                HTTPMessage.indexOf("HTTP/1.1") - 1);
                requestedFile = requestedFile.trim();
  }