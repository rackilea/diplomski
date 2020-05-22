SharedPreferences sharedPreferences = getSharedPreferences("NameList", MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();

editor.putString("Name1", playerName);

editor.apply();