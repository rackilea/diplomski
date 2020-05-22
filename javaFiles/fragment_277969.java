import java.util.logging.Level;
import java.util.logging.Logger;

public class PaintThread extends Thread{

    Panel panel;

    PaintThread(Panel panel){
        this.panel = panel;
    }

    @Override
    public void run() {
        for(int i = 0; i<5; i++){
            try {
                this.sleep(1000);
                panel.repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(PaintThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}