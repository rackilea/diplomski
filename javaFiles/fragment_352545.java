File file = new File(dirName + File.separator + fileName);
try {
    file.getParentFile().mkdirs();
    file.createNewFile();
    System.out.println("file != null");
    return file;
}
catch (Exception e)
{
    System.out.println(e.getMessage());
    return null;
}