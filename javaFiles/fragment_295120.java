package com.stackoverflow.q2357315;

import java.util.Locale;

public class Test {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("lt"));
        String s = "\u00cc";
        System.out.println(s + " (" + s.length() + ")"); // Ì (1)
        s = s.toLowerCase();
        System.out.println(s + " (" + s.length() + ")"); // i̇̀ (3)
    }
}