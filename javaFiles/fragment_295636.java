@RestController
    public class ProductController {
        @Autowired
        ProductService service;

        @RequestMapping(value = { "/", "/home" })
        public @ResponseBody ModelAndView home() {
            System.out.println("sdasasas");
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("home");
            return modelAndView;
        }
}