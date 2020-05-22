public class EntityObject<t> {
    //Is used to return the entity or entities if everything was fine
    private t entity;
    //Is used to inform of any checked exception
    private enum auth {
        NO_PASSWORD("Password cannot be empty"),
        NO_USERNAME("Username cannot be empty"), 
        USER_OR_PASSWORD_DOES_NOT_EXIST("No such username or password exist"),
        SUCCESS("OK");
        public String message;
        public auth(String message) {
            this.message = message;
        }   
    }
}