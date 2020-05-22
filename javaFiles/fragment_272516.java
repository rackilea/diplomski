public class captureScreen extends Object{

    public captureScreen() {
        ....
        filename = ".\\out.png";
        try{Robot robot = new Robot();
             ............ }
        catch(Exception e)  /* Catch Exceptions too  */
        {
            System.out.println("Error"+e);
        }
    }

    public static void main(String args[]){
        new captureScreen();
    }
}