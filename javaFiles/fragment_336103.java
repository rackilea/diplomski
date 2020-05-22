public class TheOtherClass{

    private Mainframe mainFrame;

    public TheOtherClass(){
        mainFrame = MainFrame.mainFrame; //although I would not suggest this, it will avoid the Main.mainFrame call
    }

    public void otherMethodFromOtherClass(JFrame mainFrame){
        Container content = mainFrame.getConentPane();
    }
}