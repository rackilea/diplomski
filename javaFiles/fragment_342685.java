@RestController
@Validated
public class ValidatingController {

    @RequestMapping("/{id}")
    public int validatedPath(@PathVariable("id") @Max(9) int id) {
        return id;
    }

    @ExceptionHandler
    public String constraintViolationHandler(ConstraintViolationException ex) {
        return ex.getConstraintViolations().iterator().next()
                .getMessage();
    }
}