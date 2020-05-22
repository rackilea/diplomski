package com.severityone.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharTest {

    public static void main(final String... args) {

        final String json = "{\"message\": \"Usu\\u00e1rio n\\u00e3o encontrado\", \"status\": \"fail\"}";
        final Matcher matcher = Pattern.compile("\\\\u([0-9a-z]{4})").matcher(json);
        final StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, String.format("%c", Integer.valueOf(matcher.group(1), 16)));
        }
        matcher.appendTail(result);
        System.out.println(result.toString());
    }
}