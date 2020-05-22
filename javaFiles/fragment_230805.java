public class ClassName extends Application 
{
   private boolean isSoundEnabled;

   public boolean getSoundEnabled() { return isSoundEnabled; }
   public void setSoundEnabled(boolean isEnabled) { isSoundEnabled = isEnabled;}

@Override
    public void onCreate() {
        super.onCreate();
            isSoundEnabled = true;  
}