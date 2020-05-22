@ExceptionHandler(RuntimeException.class)
public String handleRuntimeExceptions(RuntimeException exc, Model theModel) {
    if (exc instanceof HibernateException) {
        return handleHibernateException((HibernateException) exc.getCause(), theModel);
    } else if (exc.getCause() instanceof HibernateException) {
        HibernateException hibernateException = (HibernateException) exc.getCause();
        return handleHibernateException(hibernateException, theModel);
    }
    String message = "An error has occurred: " + exc.getLocalizedMessage() + "\n" + exc.getCause().toString() + "\r\n";
    myLogger.warning(message);
    theModel.addAttribute("exception", message);
    return "testing";
}