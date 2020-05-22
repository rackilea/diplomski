//Concrete controller, working with Foo entities
@Controller
@RequestMapping("/foo")
public class FooControllerImpl extends
        AbstractCRUDControllerBean<Foo, Long> implements FooController { 

  //we are interested in using fetchall but not others
  @RequestMapping(method=RequestMethod.GET)
  public @ResponseBody ResponseEntity<Foo> fetch(@PathVariable("id") PK id) { 
    return fetchAll();
  }

  //fetch with id and date
  @RequestMapping(value="/{id}/{date}", method=RequestMethod.GET)
  public @ResponseBody ResponseEntity<Foo> fetch(@PathVariable("id") PK id, @PathVariable("date") Date date) { .... }

}