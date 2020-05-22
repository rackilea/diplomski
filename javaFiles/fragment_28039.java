package barsoftware.suedtirolpointer;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.content.pm.PackageManager;

public class Berechtigungen extends AppCompatActivity {

    final int REQ_CODE_EXTERNAL_STORAGE_PERMISSION = 45;

    public void GPS() {

        if (ActivityCompat.checkSelfPermission(Berechtigungen.this, 
        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            //

        } else {

            ActivityCompat.requestPermissions(Berechtigungen.this, 
            new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE }, 
            REQ_CODE_EXTERNAL_STORAGE_PERMISSION);
        }
    }

    private void createFolder() {

        File ordner = new File(Environment.getExternalStorageDirectory(), "TestOrdner");
        ordner.mkdirs();
        Toast.makeText(getApplicationContext(), "Ordner erstellt", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQ_CODE_EXTERNAL_STORAGE_PERMISSION 
        && grantResults.length > 0 
        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            createFolder();
        }
    }
}