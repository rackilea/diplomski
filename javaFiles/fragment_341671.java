public interface JWTDecoder {
   DecodedJWT decode(String token); // I assume its string for simplicity
}

@Component
public class StdJWTDecoder implements JWTDecoder {
   public DecodedJWT decode(String token) {
       return JWT.decode(tokent);
}

public class JwtAuthenticationFilter ... {
   private final JWTDecoder jwtDecoder;

   public JwtAuthenticationFilter(JWTDecoder jwtDecoder) {
       this.jwtDecoder = jwtDecoder;
   }

    ....
   private void getJwtFromRequest(HttpServletRequest request, HttpServletResponse 
     response, FilterChain filterChain)  {
      ...
      // instead of:
      DecodedJWT jwt = JWT.decode(accessToken);  
      // use this:
      DecodedJWT jwt = jwtDecoder.decode(accessToken);
      ...
   }

}