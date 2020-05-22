import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ImportController {

    @PostMapping(value = "/import", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> importData(HttpServletRequest request) {
        String someId = "1234";

        ControllerLinkBuilder linkBuilder = ControllerLinkBuilder.linkTo(methodOn(ExportController.class).export(someId));

        URI uri = linkBuilder.toUri();

        return ResponseEntity.ok(uri);
    }

}