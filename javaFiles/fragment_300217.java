public class GenericAction extends ActionSupport  {

    private DAO dao=null;  //Interceptor injects here

    public GenericAction() {
    }

...
    @JSON(deserialize=false, serialize=false)
    public DAO getDao() {
        return dao;
    }

    @JSON(deserialize=false, serialize=false)
    public void setDao(DAO dao) {
        this.dao = dao;
    }

}