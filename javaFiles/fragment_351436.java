@ExceptionHandler
public String handle(HttpMessageConversionException e) throws Throwable {
    Throwable cause = e.getCause();
    if (cause instanceof UnrecognizedPropertyException) {
        handle((UnrecognizedPropertyException) cause);
    }
    ...
}

public String handle(UnrecognizedPropertyException e) {
    ...
}