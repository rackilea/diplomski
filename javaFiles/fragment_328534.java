package de.dhbw.file.sha1;

// TODO: Add imports

public class SHA1HashFileAsyncTask extends AsyncTask<String, Integer, String> {
    // [...]

    static {
        // loads a native library
        System.loadLibrary("SHA1Calc");
    }

    // [...]

    // native is the indicator for native written methods
    protected native void calcFileSha1(String filePath);

    protected native int getProgress();

    protected native void unlockMutex();

    protected native String getHash();

    // [...]
}