package foo.bar;

import foo.bar.service.MyService;

@Controller
public class MyService {
    @Autowired
    private MyService myService;

    @RequestMapping("/sum/{num1}/{num2}")
    public int sum(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        return myService.sum(num1, num2);
    }

}