@RestController
@RequestMapping("/")
public class Mycon {


    @Autowired
    Data data;

    @GetMapping
    public String hello(ModelMap model) {

        return data.getValues().get(0);

    }

}