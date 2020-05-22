@Controller
public class ProductController {

    @RequestMapping("/Product/UniqueId")
    public String uniqueId(Model model,
                           @RequestParam(path="code"    , required=false) String code,
                           @RequestParam(path="sig"     , required=false) String sig,
                           @RequestParam(path="pod"     , required=false) String pod,
                           @RequestParam(path="circle"  , required=false) String circle,
                           @RequestParam(path="location", required=false) String location,
                           @RequestParam(path="color"   , required=false) String color) {
        // code here
    }
}