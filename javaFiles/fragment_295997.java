public class MyServletRequestWrapper extends HttpServletRequestWrapper {
    private final HashMap<String, String[]> params;

    public MyServletRequestWrapper(HttpServletRequest request, HashMap<String, String[]> params) {
        super(request);
        this.params = params;
    }

    @Override
    public String getParameter(String name) {
        if (this.params.containsKey(name)) {
            return this.params.get(name)[0];
        }
        return "";
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return this.params;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return new Enumerator<>(params.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return params.get(name);
    }
}