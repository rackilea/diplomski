int fileSize=outArray.length;
outStream = resp.getOutputStream();
outStream.write(outArray);
outStream.flush();
outStream.close();
resp.setHeader("Content-Length", ""+fileSize);