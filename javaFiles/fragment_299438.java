@SessionScoped
public class MySessionContext {
    UserEntity userEntity;
    public UserEntity getUserEntity() {return userEntity};
    public void setUserEntity(UserEntity userEntity) {this.userEntity= userEntity};
}