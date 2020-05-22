public class AddParamsToHeader extends HttpServletRequestWrapper {
    public AddParamsToHeader(HttpServletRequest request) {
        super(request);
    }

    public String getHeader(String name) {
        String header = super.getHeader(name);
        return (header != null) ? header : super.getParameter(name); // Note: you can't use getParameterValues() here.
    }

    public Enumeration getHeaderNames() {
        List<String> names = Collections.list(super.getHeaderNames());
        names.addAll(Collections.list(super.getParameterNames()));
        return Collections.enumeration(names);
    }
}