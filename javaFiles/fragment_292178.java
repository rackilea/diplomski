public class DefaultUserSigninController implements UserSigninController {
    private UserSigninModel model;
    private UserSigninView view;

    public DefaultUserSigninController(UserSigninModel model, UserSigninView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public UserSigninModel getModel() {
        return model;
    }

    @Override
    public UserSigninView getView() {
        return view;
    }

    @Override
    public void signupUser(UserSigninView view) {
        getModel().makeUser(view.getName());
    }

    @Override
    public void authenticateUser(UserSigninView view) {
        getModel().authenticateUser(view.getName(), view.getPassword());
    }

    @Override
    public void userCreated(User user) {
        // Coordinate with the navigation controller to move to the
        // next part of the program. This might pass the User object
        // to the navigation controller (as a event) so it
        // can be seeded into the next model
    }

    @Override
    public void userCreationFailed(Exception exp) {
        getView().userSignupFailed(exp);
    }

    @Override
    public void userAuthenticated(User user) {
        // Coordinate with the navigation controller to move to the
        // next part of the program. This might pass the User object
        // to the navigation controller (as a event) so it
        // can be seeded into the next model
    }

    @Override
    public void userAuthenticationFailed(Exception exp) {
        getView().userAuthenticationFailed(exp);
    }

}