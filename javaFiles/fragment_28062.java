public class TestLoad {
public static void main(String[] args) {
    try {
        Class t1 = Class.forName("test.temp.TestDestination");
        fun temp = (fun) t1.newInstance();
        temp.fun();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (InstantiationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}