public class MyLoginBean extends org.apache.struts.action.ActionForm {

    private String[] roles;

    public MyLoginBean() {
        this.roles  = new String[]{"User"};
    }
}