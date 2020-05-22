public class EnvHolder {
  public static Environment env;

  @Autowired
  public void setEnv(final Environment environment) {
      env = environment;
  }
}