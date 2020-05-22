@RestController
public class SomeController {

    // The path variable used will be converted, resulting in the "value"-prefix 
    // being stripped in SomeConverter
    // Notice the custom '@RequiresConversion' annotation
    @GetMapping(value = "/test/{myvalue}")
    public ResponseEntity myvalue(@RequiresConversion @PathVariable Long myvalue) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // As the @RequiresConversion annotation is not present,
    // the conversion is not applied to the @PathVariable
    @GetMapping(value = "/test2/{myvalue}")
    public ResponseEntity myvalue2(@PathVariable Long myvalue) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}