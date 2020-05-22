public abstract class Operation {
    public final Response answer(String arg1, String arg2) {
        authorizeSession();
        Response res;

        if (authorized) {
            try {
                Object result = executeSpecificPart(arg1, arg2);
                res = Response.ok(result).build();
            }
            catch (MultipleExceptions ex) {
                res = handleExceptions();
            }
            finally {
                logInDatabase();
            }
        }

        return res;
    }

    protected abstract Object executeSpecificPart(String arg1, String arg2);
}

...

    public Response operation1(final String arg1, final String arg2) {
        initialize();
        Operation op1 = new Operation() {
            protected Object executeSpecificPart(String arg1, String arg2) {
                ...
            }
        };
        return op1.answer();
    }