@Component("UK" + MyFilter.SUFFIX)
public class UkFilter implements CountryFilter {

    @Override
    public boolean doFilterForCountry(ServletRequest request, ServletResponse response) 
        throws IOException, ServletException {

        // TODO Handle UK specifics here

        // VERY IMPORTANT: you might want to let the chain continue...
        return true;
        // ...or redirect to UK page
        // ((HttpServletResponse) response).sendRedirect("UK-url");
        // return false;
        // ONLY ONE of the options!
    }
}