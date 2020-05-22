// 1...
public class Controller {
    public static Frame myFrame = new Frame();

// 2, 3...
public static void main(String[] args) throws Exception
{
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Frame().setVisible(true);
            new Frame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    });

// 4...
public class Checkout{

    Frame testFrame = new Frame();

// 5...
public void simulation(){
    //...
    Frame fFrame = new Frame();