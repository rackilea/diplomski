public class MyComponent extends JPanel {
    private final JButton jButton;

    public MyComponent(){
        jButton = new JButton();
    }

    public void addActionListener(SomeCallback callback){
        jButton.addActionListener(event -> { //create listener
            callback.execute(); //invoke callback
        });
    }
}

interface SomeCallback {
    void execute();
}