new Thread(new Runnable() {
public void run() {

    //do long running blocking bg stuff here
    Display.getDefault().asyncExec(new Runnable() {
        public void run() {
            draw();
        }   
    }
}).start();