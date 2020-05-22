package de.scrum_master.aop;

import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);
        Locale.setDefault(Locale.FRENCH);
        Locale.setDefault(Locale.ENGLISH);
    }
}