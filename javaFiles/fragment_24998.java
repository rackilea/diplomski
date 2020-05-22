public class CPAuthenticationSuccessHandler extends DCAuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
        HttpServletResponse response, Authentication authentication){
        /* Do anything that you want to do here. Any changes to the HttpServletResponse
         * will be overwritten when you call super. So when you call super will
         * depend on what logic you want to implement.
         */

        super.onAuthenticationSuccess(request, response, authentication);
    }
}