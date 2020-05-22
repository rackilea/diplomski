@Component("US" + MyFilter.SUFFIX)
public class UsFilter implements CountryFilter {

    @Override
    public boolean doFilterForCountry(ServletRequest request, ServletResponse response) 
        throws IOException, ServletException {

        // TODO Handle US specifics here

        // VERY IMPORTANT: you might want to let the chain continue...
        return true;
        // ...or redirect to US page
        // ((HttpServletResponse) response).sendRedirect("US-url");
        // return false;
        // ONLY ONE of the options!
    }
}