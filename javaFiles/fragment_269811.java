import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.format.Time;
import android.widget.Switch;
import android.widget.Toast;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {

    private int Annee;
    private int Mois;
    private int Jour;
    private int Heure;
    private  int Minute;
    boolean afficher=true;
    private Handler customHandler = new Handler();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Non implementé");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) { 
        Toast.makeText(this,"Service demarré",Toast.LENGTH_LONG).show();
        customHandler.postDelayed(updateTimerThread, 3000 );
        super.onStart(intent, startId);
    }


    @Override
    public void onDestroy() {
        onStop();
        Toast.makeText(this,"Service arrété",Toast.LENGTH_LONG).show();
        customHandler.removeCallbacks(updateTimerThread);
        super.onDestroy();
    }

    public void onStop(){
    }
    private Runnable updateTimerThread = new Runnable() {
        public void run() {


            final Calendar cal = Calendar.getInstance();
                Annee = cal.get(Calendar.YEAR);
                Mois = cal.get(Calendar.MONTH)%12+1;
                Jour = cal.get(Calendar.DAY_OF_MONTH);
                Heure=cal.get(Calendar.HOUR_OF_DAY)%24+1;
                if(Heure==24)Heure=0;
                Minute=cal.get(Calendar.MINUTE);
                String min=Integer.toString(Minute);
                String heure=Integer.toString(Heure);
                String h=heure+":"+min;
                java.text.SimpleDateFormat simpleTimeFormat = new java.text.SimpleDateFormat("HH:mm");
                String h2 = null;
                try {
                    h2 = simpleTimeFormat.format(simpleTimeFormat.parse(h));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            String a, m, j;
            j = Integer.toString(Jour);
            m = Integer.toString(Mois);
            a = Integer.toString(Annee);
            String d = j + "/" + m + "/" + a;
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String d2 = null;
            try {
                d2 = simpleDateFormat.format(simpleDateFormat.parse(d));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (h2.equals("10:00")) {
                 if (afficher){
                    Intent intent =new Intent(getBaseContext(),AlertD.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("Cle",cur.getString(0));
                    getApplication().startActivity(intent);
                afficher=false;}

          }}

            customHandler.postDelayed(this , 3000 );
        };

}