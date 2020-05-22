package com.???.???;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import com.???.???.MainSettingsFragment;
public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.<SettingsActivityXML(with the FrameLayout)>);

        //If you want to insert data in your settings
        <YourSettingsFragmentClass> settingsFragment = new <YourSettingsFragmentClass>();
        settingsFragment. ...
        getSupportFragmentManager().beginTransaction().replace(R.id.<YourFrameLayout>,settingsFragment).commit();

        //Else
        getSupportFragmentManager().beginTransaction().replace(R.id.<YourFrameLayout>,new <YourSettingsFragmentClass>()).commit();
    }