SharedPreferences prefs = mContext.getSharedPreferences("RATER", 0);
    if (prefs.getBoolean("NO THANKS", false)) {
        return;
    }else {
   SharedPreferences.Editor editor = prefs.edit();
    //YOUR CODE TO SHOW DIALOG
    editor.apply();
}