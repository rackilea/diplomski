package com.stackoverflow.q2653739;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Test {

    public static void main(String... args) {
        System.out.println(removeDiacriticalMarks("Gračišće"));
    }

    public static String removeDiacriticalMarks(String string) {
        return Normalizer.normalize(string, Form.NFD)
            .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}