@Service
public class RestTemplateService {

@Autowired
RestTemplate restTemplate;


public void getInfoFromPoloniex() {
    HashMap<String,Map> answer = restTemplate.getForObject("https://poloniex.com/public?command=returnTicker",
            new HashMap<>().getClass());

    answer.values().forEach(a -> System.out.println(a.toString()));

    System.out.println(answer.get("BTC_GAME").getClass().toString());

    answer.get("BTC_GAME").keySet().stream().forEach(k -> System.out.println(k.toString()));


}