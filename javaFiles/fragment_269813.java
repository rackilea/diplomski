import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class AlertD extends Activity {
    MediaPlayer m;
    public static String cle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m=new MediaPlayer();
        cle =getIntent().getStringExtra("Cle");
        final AlertDialog alertDialog =new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Votre rendez-vous");
        alertDialog.setMessage("Vous avez un rendez-vous dans UNE HEURE !");
        alertDialog.setButton("Arréter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                m.stop();
                AlertD.super.onBackPressed();
            }
        });


        alertDialog.show();
        Alarme();
    }

    private void Alarme()  {

        try {
            if (m.isPlaying()) {
                m.stop();
                m.release();
                m = new MediaPlayer();
            }
            AssetFileDescriptor descriptor = getAssets().openFd("Alarm.mp3");
            m.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
            m.prepare();
            m.setVolume(1f, 1f);
            m.setLooping(true);
            m.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}