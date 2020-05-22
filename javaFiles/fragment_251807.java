package com.victor.main;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class FunctionalTest {
    public static void testFunction() {
        Set<Function<Book, String>> mapToFunctions = new HashSet<>();

        Function<Book, String> myFunction = x -> new String(x.getTitle());

        mapToFunctions.add(myFunction);

        for (Function<Book, String> f : mapToFunctions) {
            System.out.println(f.apply(new Book("my title")));
        }
    }

    public static void main(String[] args) {
        testFunction();
    }
}