@Controller
@RequestMapping("/owners/{ownerId}")
public class RelativePathUriTemplateController {

  @RequestMapping(value = "/pets/{petId}", params="myParam=myValue")
  public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model {    
    // implementation omitted
  }
}