@Service
public class YourService {
    private final RestTemplate rt;
    public YourService(RestTemplateBuilder rtb) {
        this.rt = rtb.build();
    }
    public YourDTO someRestCall(String param) {
        return this.rt.postForObject("/your/endpoint", YourDTO.class, param);
    }
}