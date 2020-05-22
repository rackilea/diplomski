@Controller
    @RequestMapping("/test")
    public class TestResponse {


    @RequestMapping(method=RequestMethod.GET, value="/emp/1", 
            headers="Accept=application/json")
    public @ResponseBody Employee getEmp() {
    Employee e = new Employee("ad", "asdad");
    System.out.println("Hello World");
    return e;
    }   
}