//2.
@RestController
@RequestMapping(path = "myEntity", produces="application/json; charset=UTF-8")
public class MyEntityController extends BaseController<MyEntity> {

    @RequestMapping(path={ "", "/"} , method=RequestMethod.POST)
    public ResponseEntity<MyEntity> createMyEntity(
        @ModelAttribute("entity") MyEntity myEntity) {
        //rest of method declaration...
    }

    @RequestMapping(path={ "/{id}"} , method=RequestMethod.PUT)
    public ResponseEntity<MyEntity> updateMyEntity(
        @PathVariable Long id,
        @ModelAttribute("entity") MyEntity myEntity) {
        //rest of method declaration...
    }

    @RequestMapping(path={ "/{id}"} , method=RequestMethod.PATCH)
    public ResponseEntity<MyEntity> partialUpdateMyEntity(
        @PathVariable Long id,
        @ModelAttribute("entity") MyEntity myEntity) {
        //rest of method declaration...
    }    
}