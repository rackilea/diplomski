public class APIKeyFilter extends X509AuthenticationFilter
{
    private String principalRequestHeader;

    public APIKeyFilter(String principalRequestHeader) 
    {
        this.principalRequestHeader = principalRequestHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request)
    {
        return request.getHeader(principalRequestHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request)
    {
        X509Certificate[] certs = (X509Certificate[]) request
                .getAttribute("javax.servlet.request.X509Certificate");

        if(certs.length > 0)
        {
            return certs[0].getSubjectDN();
        }

        return super.getPreAuthenticatedCredentials(request);
    }
}