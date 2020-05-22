package xx.yy.zz.controllers;

//imports here...

@Controller
public class IndexController {

    @RequestMapping(value={"/", "/index", "/welcome"}, method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        System.out.println("Kontrola do konzole");

        map.put("msg", "This is index page");

        //it will be redirected to /WEB-INF/jsp/index.jsp (make sure that have this page)
        return "index";
    }
}