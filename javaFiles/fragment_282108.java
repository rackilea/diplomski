byte[] fileByte = Files.readAllBytes(filePath);
writer.writeBytes("HTTP/1.1 200 OK\r\n");
writer.writeBytes("Content-Type: image/gif\r\n");
writer.writeBytes("Content-Length: "+fileByte.length+"\r\n");
writer.writeBytes("\r\n");
writer.write(fileByte, 0, fileByte.length);