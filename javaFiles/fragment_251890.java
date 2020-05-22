public class Context { 
    private static ThreadLocal<Context> instance = new ThreadLocal<Context>();
    private HttpServletRequest request;
    private List<Exception> exceptions = new ArrayList<Exception>();

    private Context(HttpServletRequest request) {
        this.request = request;
        this.request.setAttribute("exceptions", exceptions);
    }

    public static Context getCurrentInstance() {
        return instance.get();
    }

    public static Context newInstance(HttpServletRequest request) {
        Context context = new Context(request);
        instance.set(context);
        return context;
    }

    public void release() {
        instance.remove();
    }

    public void addException(Exception exception) {
        exceptions.add(exception);
    }
}