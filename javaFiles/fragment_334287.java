public class GetDatabase {
    private final Properties properties = new Properties();
    {
        final ClassLoader loader = getClass().getClassLoader();
        try(InputStream config = loader.getResourceAsStream("config.properties")){
            properties.load(config);
        } catch(IOException e){
            throw new IOError(e);
        }
    }

    // The rest of your code
}