package com.example.testcheckbox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends ActionBarActivity {

    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    cb = (CheckBox) findViewById(R.id.checkbox);
    cb.setChecked(true);
    cb.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {

        CharSequence options[];

        if (isChecked) {
        cb.setChecked(false);
        options = new CharSequence[] { "Mark as Complete", "Cancel" };
        } else {
        cb.setChecked(true);
        options = new CharSequence[] { "Mark as Incomplete", "Cancel" };
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setItems(options, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
            case 0: {
            cb.setOnCheckedChangeListener(null);
            cb.toggle();
            cb.setOnCheckedChangeListener(mOnCheckedChangeListener);
            }
            }

        }
        });
        builder.show();
    }
    };
}