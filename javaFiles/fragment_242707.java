package com.example.thestjni;

class MainActivity {
    static {
        System.loadLibrary("thirdparty");
    }
    public native static String stringFromJni();
}