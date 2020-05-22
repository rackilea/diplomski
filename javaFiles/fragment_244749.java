public class SettingsHolder{

   public static SettingsHolder instance;

   public SettingsHolder{

       if(instance == null)
           instance = this; 
   }