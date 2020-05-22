Properties properties = new Properties();
FileInputStream fis = null;
try {
    fis = new FileInputStream("filename.properties");
    properties.load(fis);
} catch (FileNotFoundException e) {
    system.out.println("FileNotFound");
} catch (IOException e) {
    system.out.println("IOEXCeption");
} finally {
    if (null != fis)
    {
        try
        {
            fis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}