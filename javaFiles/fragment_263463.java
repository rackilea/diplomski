@Component
public class MyController {

  private final MyClient MyClient;

  private MyTokenClient tokenClient;
  private String MyUserId;
  private String MyPassword;

  @Autowired
  public MyController(@Value("${My.base-url}") String baseUrl) {
    this.tokenClient = Feign.builder().contract(new SpringMvcContract())
      .encoder(new GsonEncoder())
      .decoder(new GsonDecoder())
      .logger(new Slf4jLogger(MyTokenClient.class))
      .logLevel(feign.Logger.Level.FULL)
      .requestInterceptor(new BasicAuthRequestInterceptor("USER", "PASSWORD"))
      .target(MyTokenClient.class, baseUrl);
    this.MyClient = Feign.builder().contract(new SpringMvcContract())
      .requestInterceptor(new MyRequestInterceptor()).target(MyClient.class, baseUrl);
  }
}