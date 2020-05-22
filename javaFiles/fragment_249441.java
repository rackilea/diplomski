if( ! preferences.getBoolean("screen_show", false)){
    // if show screen 
    Intent showscreenIntent=new(this,ShowScreen_Intent.class);
    startActivity(showscreenIntent);
} else {
    //
}