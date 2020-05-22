import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button b;
    private boolean loaded;
    private int soundID;
    private SoundPool soundPool;
    private float volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b = (Button) findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loaded) {
                    soundPool.play(soundID, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }
        });

        Intent intent_upload = new Intent();
        intent_upload.setType("audio/*");
        intent_upload.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent_upload, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                try {
                    //the selected audio.
                    Uri uri = data.getData();
                    String path = _getRealPathFromURI(MainActivity.this, uri);
                    Log.e("test", "" + path);
                    soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
                    soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                        @Override
                        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                            loaded = true;
                        }
                    });
                    soundID = soundPool.load(path, 1);
                    AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                    float actualVolume = (float) audioManager
                            .getStreamVolume(AudioManager.STREAM_MUSIC);
                    float maxVolume = (float) audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                    volume = actualVolume / maxVolume;
                    if (loaded) {
                        soundPool.play(soundID, volume, volume, 1, 0, 1f);
                        Log.e("Test", "Played sound");
                    }
                } catch (Exception e) {
                    Log.e("Test", "error" + e);
                }

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private String _getRealPathFromURI(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Audio.Media.DATA};
        CursorLoader loader = new CursorLoader(context, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}