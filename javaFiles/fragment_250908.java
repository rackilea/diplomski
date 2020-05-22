package com.example.bibiwars.skills;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends ActionBarActivity {
final ArrayList<String> places =  = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ImageView img = (ImageView) findViewById(R.id.logo);
    img.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            //ToastMessage to test the click ::::::
            Toast.makeText(MainActivity.this, "Clicked!!",Toast.LENGTH_SHORT).show();
            TextView text = (TextView) findViewById(R.id.text);
            if(places.size() >0)
            {
                int rnd = new Random().nextInt(places.size());
                text.setText(places.get(rnd));
                places.remove(rnd);
            }
        }

    });
}
//... other methods...
}