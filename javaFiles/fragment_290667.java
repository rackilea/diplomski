import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.nomzapp.About;

public class MainActivity extends Activity {
    Button exitbu;
    Button aboutbu;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    aboutbu = (Button) findViewById(R.id.aboutbu);
    aboutbu.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent i = new Intent(MainActivity.this, About.class);
            startActivity(i);
        }
    });
    exitbu= (Button) findViewById(R.id.exitbu);
    exitbu.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            System.exit(0);
        }
    });


 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
 }

}