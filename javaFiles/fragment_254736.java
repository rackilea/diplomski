public class BeanClass {

    private static BeanClass instance = new BeanClass();

    private BeanClass(){
    }        

    public static BeanClass getter(){
       return instance;
    }
}