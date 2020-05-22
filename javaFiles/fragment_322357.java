SharedPreferences settings = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
SharedPreferences.Editor editor = settings.edit();

editor.putString(ACCESS_TOKEN_STRING, token);

/* Commit the edits */
editor.commit();