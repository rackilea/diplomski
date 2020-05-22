//Close document and outputStream.
servletOutPutStream.flush();
outputStream.flush();
document.close();
outputStream.close();

servletOutPutStream.close();