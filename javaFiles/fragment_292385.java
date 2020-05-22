package pete.android.study;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity{

    private String mEpisode = "";
    private String mPage = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        showDialog();

    }

    private void showDialog(){
        AlertDialog.Builder alertdg = new AlertDialog.Builder(this); 
        alertdg.setTitle("Choose page");
        alertdg.setMessage("Choose episode/page");

        final EditText page = new EditText(this); 
        final EditText episode = new EditText(this); 
        page.setWidth(210); 
        episode.setWidth(210); 

        LinearLayout layout = new LinearLayout(this); 

        layout.addView(episode); 
        layout.addView(page); 
        alertdg.setView(layout); 

        alertdg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                mEpisode = episode.getText().toString();
                mPage = page.getText().toString(); 

                Toast.makeText(MainActivity.this, mEpisode + " | " + mPage,  Toast.LENGTH_SHORT).show();
            }
        });

        alertdg.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }
        });
        alertdg.show();


    }


}