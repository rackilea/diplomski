public class Config {
    private final String p = "Prop";

    @Bean(name="p")
    public String getP(){return p;}
}