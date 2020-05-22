import android.app.AlarmManager;
import android.content.Context;
import android.provider.Settings;
import java.util.Date;

public class Controller extends {  **//does not need to be a Activity any more**

    /**
     * Finds out what the next user scheduled alarm is.
     *
     * @return (String) next time the user has scheduled an alarm on his device.
     */
    protected static String nextAlarm(Context context) { //**pass Context from other Activity** 

        String nextAlarmTime = null;

        // deprecated method will also detect non native alarm clocks!
        nextAlarmTime = Settings.System.getString(context.getContentResolver(),  //**reference parameter here**
                Settings.System.NEXT_ALARM_FORMATTED);

        // fallback if deprecated method does not find valid alarm time!
        if (nextAlarmTime == null) {
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE); // **reference parameter again**
            AlarmManager.AlarmClockInfo alarmInfo = am.getNextAlarmClock();
            Long alarm_next = alarmInfo.getTriggerTime();
            nextAlarmTime = (new Date(alarm_next)).toString();
        }

        return nextAlarmTime;
    }

}