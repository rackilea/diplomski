package com.example.myproject;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import android.app.Application;

public class UILApp extends Application{

@Override
public void onCreate() {
    super.onCreate();

    ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();

    ImageLoader.getInstance().init(configuration);

}

}