public class Preference extends PreferenceActivity {

   private PrefernceChangeListener prefernceChangeListener;

   public void addPreferenceChangeListener(PrefernceChangeListener prefernceChangeListener){
     this.prefernceChangeListener = prefernceChangeListener;
   }

   public PrefernceChangeListener getPrefernceChangeListener(){
     return this.prefernceChangeListener;
   }    
}