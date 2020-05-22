@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    ...
}

@Controller
public class SomeController {
    @RequestMapping.....
    public void handleCall() {
        if (isFound()) {
            // whatever
        }
        else {
            throw new ResourceNotFoundException(); 
        }
    }
}