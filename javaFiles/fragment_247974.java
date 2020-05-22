@Component
public class ExtendedInfoEndpoint implements InfoContributor {
    Map<String, Integer> userDetails = new HashMap<>();
    userDetails.put("teste", 23);
    userDetails.put("teste2", 22);      
    builder.withDetail( "menuitems", userDetails );
}