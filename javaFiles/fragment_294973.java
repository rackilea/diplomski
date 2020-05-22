package de.scrum_master.aop;

import java.util.Locale;

public aspect DefaultLocaleWatchdog {
    after() : call(* Locale.setDefault(*)) {
        System.out.println("Default locale has been changed to " + Locale.getDefault());
    }
}