try
{
java.net.URL url = this.getClass().getResource("/resources/SQL.properties");

java.io.FileInputStream pin = new java.io.FileInputStream(url.getFile());

java.util.Properties props = new java.util.Properties();

props.load(pin);
}
catch(Exception ex)
{
ex.printStackTrace();
}