@Controller
public class CloudFoundryController {
...

   @RequestMapping(value = {"/servlet/v2/catalog"}, method = RequestMethod.GET
   public HttpResponse getV2Catalogue() {
      ...
   }
}