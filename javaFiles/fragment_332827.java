this.session.userLocalStorage().addUser(realm, user.getUsername());

    @Override
public UserModel addUser(RealmModel realm, String username) {
    // userModel returned should be subclassed or instance of AbstractUserAdapterFederatedStorage
    return this.myUserModel;

}