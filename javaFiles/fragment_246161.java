public void createDirectory (String path)
{
    File directory = new File(path);
    if (!directory.exists()) {
        if (!directory.mkdir()) {
            System.out.println("couldn't create file");
        }
    }
}