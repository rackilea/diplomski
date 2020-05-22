public abstract class PushQueueHttpServlet extends HttpServlet {

    @Override
    protected final void doGet(HttpServletRequest req, HttpServletResponse res) throws
            IOException, ServletException {
        try {
            doGet2(req, res);
        } catch (Throwable throwable) {
            String retryCountString = req.getHeader("X-AppEngine-TaskRetryCount");

            int retryCount;
            try {
                retryCount = Integer.parseInt(retryCountString);
            } catch (NumberFormatException e) {
                // Probably running outside of the task queue
                throw throwable;
            }

            if (retryCount == getTaskRetryLimit()) {
                throw throwable;
            } else {
                throw new SuppressedException(throwable);
            }
        }
    }

    protected abstract void doGet2(HttpServletRequest req, HttpServletResponse res) throws
            IOException, ServletException;

    protected abstract int getTaskRetryLimit();
}