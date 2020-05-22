public class Utilities { 

   // static variable of Ringtone
   private static Ringtone mRingtone = null;

   // static variable of AudioManager
   private static AudioManager mAudioManager = null;

   // static method to get instance of Ringtone
   public static Rington getRingtone(Context mContext) { 

      if (mRingtone == null) {
           mRingtone = RingtoneManager.getRingtone(mContext.getApplicationContext(),
            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)); 
       }

    return mRingtone; 

   } 

   // static method to get instance of AudioManager
   public static AudioManager getAudioManager(Context mContext) { 

      if (mAudioManager == null) {
           mAudioManager = mContext.getApplicationContext().getSystemService(AUDIO_SERVICE);
       }

    return mAudioManager; 

   } 
}