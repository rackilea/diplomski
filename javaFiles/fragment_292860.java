public interface Config {
    String getKey();
}

public enum DevelopmentConfig implements Config
{
    URL("url"),
    DEFAULT_URL("defaulturl");

    private String key;

    private DevelopmentConfig(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}