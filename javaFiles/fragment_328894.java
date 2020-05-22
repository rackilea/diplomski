@Controller
public class controller {

    @RequestMapping(value = "hai")
    public @ResponseBody String hai(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "pass",required = false) String pass) {
        Map ma=new HashMap();
       ma.put("name", name);
       ma.put("pass", pass);
        System.out.println(name);
        Gson ob=new Gson();
        ob.toJson(ma);

        return ob.toJson(ma);

    }