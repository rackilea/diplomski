final Properties properties = new Properties();
try (final FileInputStream fis =
         new FileInputStream("filename.properties"))
{
    properties.load(fis);
} catch (FileNotFoundException e) {
    system.out.println("FileNotFound");
} catch (IOException e) {
    system.out.println("IOEXCeption");
}