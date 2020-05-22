public interface CommentProjection {

    Long getId();

    String getComment();

    @Value("#{target.user.id}")    
    Long getUserId();

    @Value("#{target.place.id}")              
    Long getPlaceId();

    @Value("#{target.user.userProfile.firstName}")
    String getComentatorName();
}