public class PlayText extends Thread {

   private int duration;
   private String text;
   private PlayerScreen playerscrn; 

    public PlayText(String text, int duration) {
        this.duration = duration;
        this.text = text;
        this.playerscrn = (PlayerScreen)UiApplication.getUiApplication().getActiveScreen();
    }

    private void displayTextLabel(string textToDisplay){
        synchronized(UiApplication.getEventLock()) {
            playerscrn.add(new RichTextField(textToDisplay, Field.NON_FOCUSABLE));
            playerscrn.invalidate();
        }
    }

    public void run() {

            try{

                displayTextLabel(this.text);
                Thread.sleep(this.duration);

                displayTextLabel("hahhaha");
                Thread.sleep(1000);

                displayTextLabel("Done");

            }catch(Exception e){
             System.out.println("I HAVE AN ERROR");
            }   
        }
    }
}