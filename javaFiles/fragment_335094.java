public interface TokenUtils {
    String getToken(UserDetails userDetails);
    String getToken(UserDetails userDetails, Long expiration);
    boolean validate(String token);
    UserDetails getUserFromToken(String token);
}