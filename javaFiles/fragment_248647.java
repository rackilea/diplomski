package de.lhorn.stackoverflow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern phoneNumber = Pattern
                .compile("^(\\d{1,3})[- ](\\d{1,3})[- ](\\d{4,10})$");

        Matcher matcher = phoneNumber.matcher("1-425-9854706");
        if (matcher.matches()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }

    }
}