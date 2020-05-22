public class MyAction extends GenericAction {

    public MyAction() {
    }

    @Override
    public String execute() throws Exception {
        super.execute();
        UserDAO userDAO=new UserDAO(getDao().getS());
        OtherDAO otherDAO=new OtherDAO(getDao().getS());
        userDAO.loadUsers(...);
            return SUCCESS;
    }
}