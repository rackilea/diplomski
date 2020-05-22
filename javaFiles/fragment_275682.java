private Handler playMorseHandler = new Handler();
private String morseChars = ".--...---"; // I don't know where you set this
private int charIndex = 0;
private Runnable playMorseTask = new Runnable() {
    if (morseChars == null ||
        charIndex < 0 ||
        charIndex >= morseChars.length()) {
        Log.w("whateverTag", "Basic assumptions failed");
        return;
    }
    char ch = morseChars.charAt(charIndex);
    long lengthOfClip = 0L;
    boolean postAgain = true;
    if (ch == '.') {
        Log.d("play: ", "dot");
        lengthOfClip = 300L; // I don't know how long your clips are
        try {
            startPlayback();
        } catch (Exception e){
            e.printStackTrace();
        }
    } else if (ch == '-') {
        Log.d("play: ", "dash");
        lengthOfClip = 500L; // I don't know how long your clips are
        try {
            startPlayback();
        } catch (Exception e){
            e.printStackTrace();
        }
    } else {
        Log.d("whateverTag", "unexpected input");
        postAgain = false;
    }
    ++charIndex;
    if (postAgain && charIndex < morseChars.length()) {
        playMorseHandler.postDelayed(this, lengthOfClip);
    }
};