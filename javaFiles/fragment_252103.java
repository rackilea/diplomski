public class BeanA() {

    @Resource
    private BeanB b;

    public void importDataToDB(){
        b.executeInsertUpdateQuery();
    }
}

public class BeanB {

    @Transactional
    public void executeInsertUpdateQuery(){
        //all the good stuff goes in here
    }

}