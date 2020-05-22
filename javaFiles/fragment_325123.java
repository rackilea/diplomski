@Controller
public class MyController {     
    @Value("${api.orders.pingFrequency}")
    private Integer pingFrequency;
    ...
}