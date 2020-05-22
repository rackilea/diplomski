public class TokenAuthenticationFilter extends GenericFilterBean
    {


        @Override
        public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
                throws IOException, ServletException
        {
            final HttpServletRequest httpRequest = (HttpServletRequest)request;

             //extract token from header
            final String accessToken = httpRequest.getHeader("header-name");
            if (null != accessToken) {
           //get and check whether token is valid ( from DB or file wherever you are storing the token)

          //Populate SecurityContextHolder by fetching relevant information using token
               final User user = new User(
                            "username",
                            "password",
                            true,
                            true,
                            true,
                            true,
                            authorities);
                    final UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);

            }

            chain.doFilter(request, response);
        }

      }