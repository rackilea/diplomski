public class MyRequestHeaderAuthenticationFilter extends 
                                      RequestHeaderAuthenticationFilter {

            @Override
            protected void unsuccessfulAuthentication(HttpServletRequest request, 
                  HttpServletResponse response, AuthenticationException failed) {

                super.unsuccessfulAuthentication(request, response, failed);

                // see comments in Servlet API around using sendError as an alternative
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }