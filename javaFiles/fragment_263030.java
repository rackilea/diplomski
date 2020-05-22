DiskFileItem fileItem = new DiskFileItem("file", "image/png", true, file.getName(), (int)file.length() , file.getParentFile());
InputStream input =  new FileInputStream(file);
OutputStream os = fileItem.getOutputStream();
int ret = input.read();
while ( ret != -1 )
{
    os.write(ret);
    ret = input.read();
}
os.flush();
MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
Assert.assertTrue(multipartFile.getSize() > 0);