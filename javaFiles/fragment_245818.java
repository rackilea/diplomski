int fileSize=outArray.length;
resp.setHeader("Content-Length", ""+fileSize);
outStream = resp.getOutputStream();
outStream.write(outArray);
outStream.flush();
outStream.close();