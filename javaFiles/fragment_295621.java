package com.app.services;

public class ServicesVersionInfo {

    public static String getVersion() {
        return getVersionNumber() + " " + getVersionStage();
    }

    public static String getVersionNumber() {
        return "1.0.0";
    }

    public static String getVersionStage() {
        return "ALPHA";
    }
}