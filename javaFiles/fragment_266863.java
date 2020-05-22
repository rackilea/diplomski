package com.pm.pm;

import android.os.Bundle;
import org.apache.cordova.*;

import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.DroidGap;

import android.util.Log;
import android.webkit.WebView;

import android.content.Context;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class MyClass extends DroidGap
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.init();

        CordovaWebViewClient webViewClient = new CustomCordovaWebViewClient(this);
        webViewClient.setWebView(this.appView);
        this.appView.setWebViewClient(webViewClient);

        super.loadUrl(Config.getStartUrl());
    }    

    public class CustomCordovaWebViewClient extends CordovaWebViewClient {

         public CustomCordovaWebViewClient(DroidGap ctx) {
           super(ctx);
         }

         @Override
         public boolean shouldOverrideUrlLoading(WebView view, String url) {
             if (isNetworkAvailable()) {
                 Log.i("TEST", "shouldOverrideUrlLoading, we have internet, loading: " + url);
                 return false;
             }
             Log.i("TEST", "shouldOverrideUrlLoading, NO internet, NOT loading: " + url);
             return true;
         }

         public boolean isNetworkAvailable() {
             ConnectivityManager connec = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
             NetworkInfo ni = connec.getActiveNetworkInfo();
             if (ni == null) {
                 // There are no active networks.
                 return false;
             }
             return true;
         }
    }
}