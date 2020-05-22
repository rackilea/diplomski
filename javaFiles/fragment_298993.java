public class EntityObject<t> {
    //Is used to return the entity or entities if everything was fine
    private t entity;
    //Is used to inform of any checked exception
    private enum auth {
        NO_PASSWORD, NO_USERNAME, USER_DOES_NOT_EXIST, SUCCESS    
    }
}