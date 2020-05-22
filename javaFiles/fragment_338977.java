SharedPreferences pref = getSharedPreferences("SavedGame", MODE_PRIVATE); 
SharedPreferences.Editor editor = pref.edit();      
editor.putInt("Lifes", 6);
editor.putInt("Hints", 6);          
editor.putInt("Level", 1);  
editor.commit();