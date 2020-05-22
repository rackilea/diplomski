package fr.demo.appli.navigation;

import android.app.Activity;
import android.content.Intent;

public class Navigation {
    public static class Screens {
        //
        public static String Activity1Activity = "Activity1Activity";
        public static String Activity2Activity = "Activity2Activity";
    }
    public static void showActivity(Activity curActivity, String nextActivityName) {
        Intent intent = new Intent(nextActivityName);
        curActivity.startActivity(intent);
    }
}