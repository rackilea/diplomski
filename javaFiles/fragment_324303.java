@Service
public class MyService {
    @Value("${mysetting}")
    private int mysetting;  //Spring will inject '42' on bean creation

    //...
}