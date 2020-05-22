public class EncrypterFactory
{
   Properties properties;
   File file;

   public void setLocation(String fileName)
   {
      this.file = new File(fileName);
   }
   public void init() throws IOException
   {
      properties = new Properties();
      properties.load(new FileReader(file));
   }

   public Encrypter createInstance()
   {
      Encrypter encrypter = new Encrypter();
      encrypter.setSomeOption(properties.getProperty("plain-text-property"));
      return encrypter;
   }
}