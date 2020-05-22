package com.stackoverflow.q42913242;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("javadoc")
public class Answer {

    static final DateTimeFormatter FROM_PATTERN = DateTimeFormatter.ofPattern("h:mma");

    static final DateTimeFormatter TO_PATTERN = DateTimeFormatter.ofPattern("h:mm a");

    public static void main(String[] args) {

        System.out.println(convert("5:00pm"));

        System.out.println(convert("12:00AM"));
    }

    public static String convert(String input) {
        final LocalTime localTime = LocalTime.parse(input.toUpperCase(), FROM_PATTERN);
        return localTime.format(TO_PATTERN);
    }
}