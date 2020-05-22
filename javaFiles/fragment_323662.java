@Component(MyFilter.DEFAULT + MyFilter.SUFFIX)
public class DefaultFilter implements CountryFilter {

    @Override
    public boolean doFilterForCountry(ServletRequest request, ServletResponse response) 
        throws IOException, ServletException {

        // TODO Handle DEFAULT specifics here

        // VERY IMPORTANT: you might want to let the chain continue...
        return true;
        // ...or redirect to DEFAULT page
        // ((HttpServletResponse) response).sendRedirect("DEFAULT-url");
        // return false;
        // ONLY ONE of the options!
    }
}