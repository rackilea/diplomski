public class GameLoop implements Runnable {
    public void run() {
        //initialization goes here
        while(running){
            processInput();
            update();
            render();
        }
    } 
    processUpdate() {
         //here you listen to inputs
    }
}