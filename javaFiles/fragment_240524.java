@Data
public class CommentProjection {

    @Value("#{target.user}")    
    private final User theUser; // throw PropertyReferenceException: No property theUser found for type Comment!
}