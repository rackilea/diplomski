public class AClassIDontKnow {

    private DomainModelMapper mapper;//inject this
    //Life-cycle method
    public void execute(FrameworkBlob frameworFattyObject) {
        ...
        UserDomainModel user = mapper.getUser(frameworFattyObject);
        UserDomainModel loggedInUser = getLoggedInUserFromSomewhere();
        bool areFriends = user.isFriendOf(loggedInUser);
        ...  
    }
}

public class DomainModelMapper {
    UserDomainModel getUser(FrameworkBlob frameworFattyObject) {
         User userAnemicModel = frameworFattyObject.getUser();
         //map the anemicModel to a rich domain model
         return ....;
    }
}