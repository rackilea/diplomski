public class LoginPage {

    // Class Data
    private HtmlForm loginForm;

    // Calling the constructor of the parent class
    public LoginPage() {
        loginForm = null;
    }

    // Normal setter - NB: Private - so I am in complete control.
    private void setLoginForm(HtmlForm loginForm) {
        this.loginForm = loginForm;
    }

    private void initialiseLoginForm() {
        if ( loginForm == null ) {
            // Build a loginForm and use the private setter to set it.
            // NB: In a multi-threaded environment you would normally use some kind of synchronization.
            HtmlForm newForm;
            // ...
            setLoginForm(newForm);
        }
    }

    // Normal getter
    public HtmlForm getLoginForm() {
        initialiseLoginForm();
        return loginForm;
    }

}