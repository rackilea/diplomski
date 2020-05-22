@Override
public void run(){
    while(true){
        try {
            Thread.sleep(100);
            mSec++;
            if(mSec >= 10){
                mSec = 0;
                sec++;
                Platform.runLater(()->zeit.set("Zeit: " + sec));
                System.out.println(zeit.get());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Uhr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}