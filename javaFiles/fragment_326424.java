public class MyAction extends ActionSupport {
    private String firstName;

    public String execute() throws Exception {
        // do something here
        return SUCCESS;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
}