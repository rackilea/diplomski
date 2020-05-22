public class First {

    public void one() {
        JFrame obj = new JFrame();
        obj.setSize(200, 200);
        obj.setVisible(true);
    }


    public static void main(String[] args) {
        First first = new First();  // instantiate your First object
        first.one();  // run your "one" method
    }
}