@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        final String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) 
        {
            String authToken = header.substring(7);
            System.out.println(authToken);

            try
            {
                String username = jwtTokenUtil.getUsernameFromToken(authToken);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null)
                {
                    if (jwtTokenUtil.validateToken(authToken, username))
                    {
                        List<GrantedAuthority> authList = new ArrayList<>();
                        authList.add(new SimpleGrantedAuthority("ROLE_APIUSER"));

                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, null, authList);
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Unable to get JWT Token, possibly expired");
            }
        }

        chain.doFilter(request, response);
    }
}