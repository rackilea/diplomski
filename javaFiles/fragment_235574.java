public class Testiue 
{
    private UserDao dao;


    public String add()
    {
dao=new UserDao();
        UseBean bean = new UseBean();
        System.out.println(bean.getName());
        dao.addUser(bean);
        return ActionSupport.SUCCESS;

    }

}