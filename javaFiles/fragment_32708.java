public class MyButton extends JButton{
    private Runnable onActionPerfomed;

    public Runnable getMyAction(){
        return onActionPerfomed;
    }

    public void setMyAction(Runnable r){
        onActionPerfomed = r;
    }
}

final MyButton button = new MyButton();
button.setName("button xpto");
button.setMyAction(new Runnable() {

    @Override
    public void run() {
        System.out.println("Hey I'm running this on button " + button.getName());
    }
});

button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof MyButton){
            MyButton btn = (MyButton)e.getSource();
            btn.getMyAction().run();
        }
    }
});