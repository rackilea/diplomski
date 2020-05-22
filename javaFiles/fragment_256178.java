@Controller
class MyController2 {

    @RequestMapping("/index.html")
    @SubdomainMapping("www")
    public function index_www(Map<Object, String> map){
        // on www.domain.com
        // where ".domain.com" is defined in SubdomainMapping.java
    }

    @RequestMapping("/index.html")
    @SubdomainMapping("custom")
    public function index_custom(Map<Object, String> map){
        // on custom.domain.com
        // where ".domain.com" is defined in SubdomainMapping.java
    }
}