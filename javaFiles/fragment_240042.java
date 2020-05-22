//This is where the magic happens. 
//This is your custom ExceptionMapper for ConstraintViolationException
@Provider
public class CustomExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException cve) {
        //List to store all the exceptions that you whish to output
        //ValidationErrors is a custom object, which you can see further down
        ValidationErrors validationErrors = new ValidationErrors();

        //Loop through all the ConstraintViolations
        for(ConstraintViolation<?> c : cve.getConstraintViolations()){

            //We retrieve the variable name or method name where the annotation was called from.
            //This will be your property name for your JSON output.
            String field = ((PathImpl)c.getPropertyPath()).getLeafNode().getName();

            //If field is null, then the notation is probably at a class level.
            //Set field to class name
            if(field == null){
                field = c.getLeafBean().getClass().getSimpleName();
            }

            //c.getMessage() is the error message for your annotation.
            validationErrors.add(field, c.getMessage());
        }
        //Return a response with proper http status.
        return Response.status(422).entity(validationErrors).build();
    }
}