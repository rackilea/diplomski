/**
 * Shows a friendly message instead of the exception stack trace.
 * @param pe exception.
 * @return the exception message.
 */
@ExceptionHandler(PersistenceException.class)
@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public String handlePersistenceException(final PersistenceException pe) {
    String returnMessage;
    if (pe.getCause()
            instanceof ConstraintViolationException) {
        ConstraintViolationException cve =
                (ConstraintViolationException) pe.getCause();
        ConstraintViolation<?> cv =
                cve.getConstraintViolations().iterator().next();
        returnMessage = cv.getMessage();
    } else {
        returnMessage = pe.getLocalizedMessage();
    }
    if (pe instanceof EntityExistsException) {
        returnMessage = messages.getMessage("user.alreadyexists");
    }
    return returnMessage;
}