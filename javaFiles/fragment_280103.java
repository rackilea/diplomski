package com.pfc.camera.ndkmain;

public class MainActivity extends Activity {

    native int compression(String[] argv);

    public int foo(String[] args) {
        return compression(args);
    }
}