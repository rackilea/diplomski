package com.example.pablo.zad3;

import android.content.SharedPreferences;
import android.content.Context;
import android.os.AsyncTask;

public class Background extends AsyncTask<Integer,Void,String>{

    private Context context;

    public Background(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Integer... params) {
        Integer n = params[0];
        StringBuilder sb=new StringBuilder();
       for(int i=1;i<250;i++)
       {
           sb.append(i+ " ");
           sb.append(n*i+"\n");
       }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
    }
}