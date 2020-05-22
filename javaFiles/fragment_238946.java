/**
* Gets the state of Airplane Mode.
* 
* @param context
* @return true if enabled.
*/
private static boolean isAirplaneModeOn(Context context) {

   return Settings.System.getInt(context.getContentResolver(),
           Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

}