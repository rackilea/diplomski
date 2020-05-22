public class AlarmReciever extends BroadcastReceiver {
@Override
public void onReceive(Context context, Intent intent) {

    Print("intent "+intent.getAction());
    Log.d("Alarm ", "Alarm triggered!");



    Intent activityIntent = new Intent(context, ActivityToOpen.class).putExtra("byAlarm","yes");
    context.startActivity(activityIntent); //start



}