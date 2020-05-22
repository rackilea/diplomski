package com.example.myapplication;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Context context = getApplicationContext();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    Toast toasth = Toast.makeText(context , R.string.title_home, Toast.LENGTH_LONG);
                    toasth.show();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    Toast toastd = Toast.makeText(context , R.string.title_dashboard, Toast.LENGTH_LONG);
                    toastd.show();
                    loadCalFragment();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_location);
                    Toast toastn = Toast.makeText(context , R.string.title_location, Toast.LENGTH_LONG);
                    toastn.show();
                    return true;
            }
            return false;
        }
    };


    private void loadCalFragment() {
        CalFragment fragment = CalFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    }