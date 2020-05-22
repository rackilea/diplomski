package org.me.myandroidstuff;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelloWorldActivity extends Activity implements OnClickListener {
    private View mainView;

    private TextView tbox1;

    private Button exitButton;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainView=(View)findViewById(R.id.mainView);
        mainView.setBackgroundColor(getResources().getColor(R.color.silver));

        tbox1 = (TextView)findViewById(R.id.textBox1);
        tbox1.setTypeface(Typeface.MONOSPACE);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
    }
}