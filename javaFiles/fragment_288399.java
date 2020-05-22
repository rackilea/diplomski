BufferedInputStream bis = new BufferedInputStream(
    new FileInputStream(new File("/path/to/folder", "file.pdf")));
ServletOutputStream outStream = response.getOutputStream();
//to make it easier to change to 8 or 16 KBs
//make some tests to determine the best performance for your case
int FILE_CHUNK_SIZE = 1024 * 4;
byte[] chunk = new byte[FILE_CHUNK_SIZE];
int bytesRead = 0;
while ((bytesRead = bis.read(chunk)) != -1) {
    outStream.write(chunk, 0, bytesRead);
}
bis.close();
outStream.flush();
outStream.close();