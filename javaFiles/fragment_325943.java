@HandlesExceptions
public class ExceptionHandler {
    public void handleServletException(
            final @Handles @WebRequest CaughtException<ServletException> caught,
            @Context final HttpServletResponse response) {
        try {
            response.sendError(500, "An error occured");
        } catch (final IOException ioe) {
            System.err.println("Dumb IO Exception: " + ioe);
        }
    }
}