public final static String HIGH_SCORE = "com.example.helloworld.HIGH_SCORE";
public final static String LEVELS = "com.example.helloworld.LEVELS";

SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putInt(HIGH_SCORE, newHighScore);
editor.putInt(LEVELS, level);
editor.commit();