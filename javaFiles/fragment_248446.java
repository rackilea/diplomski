public class SecondClass extends JFrame {

    private static SecondClass instance;

    public static SecondClass getInstance() {
        if(SecondClass.instance == null)
            SecondClass.instance = new SecondClass();

        return SecondClass.instance
    }

}