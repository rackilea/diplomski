//Saving a boolean on no thanks button click

SharedPreferences prefs = mContext.getSharedPreferences("RATER", 0);
SharedPreferences.Editor editor = prefs.edit();
editor.putBoolean("NO THANKS", true));
editor.apply();