public class MainClass implements MyListener {

    public static void main(String[] args) 
    {
        GuiClass g =  new GuiClass();
        g.addListener(this);

    }

    public void doNotify(String message) {
        System.out.println(message);
        setPostition();
    }

    private void setPosition()
        /* your code here */
    }

}