import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequestMapping(value = "/calculate")
@ResponseBody
public ResponseEntity<CalculationResult> calculate(@RequestParam(name = "op") String operation, 
    @RequestParam(name = "num1") Double num1, 
    @RequestParam(name = "num2") Double num2) {

    if(null == op || null == num1 || null == num2) {
        throw new IllegalArgumentException("{\"error\":\"At least one parameter is invalid or not supplied\"}")
    }

    System.out.print("Operation:" + operation);
    Double calculate = calculatorService.calculate(operation, num1, num2);

    return new ResponseEntity<>(new CalculationResult(calculate), HttpStatus.OK);
}    

@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public final String exceptionHandlerIllegalArgumentException(final IllegalArgumentException e) {
    return '"' + e.getMessage() + '"';
}