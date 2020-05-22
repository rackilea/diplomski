public class Foo {

  private List<Country> countries;

  // get/set...
}

@Controller
public class MyController {
    @ResponseBody
    @RequestMapping(value = "/foo", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Foo> foo() {
        Foo foo = new Foo();

        Country country = new Country();

        foo.getCountries().add(country);

        return ResponseEntity.ok(foo);
    }
}