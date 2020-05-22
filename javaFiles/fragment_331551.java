package com.ggl.testing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {

    private static boolean shuffleLetters = true;
    private static boolean shuffleColors = true;

    private static int shuffleLetterIndex = 0;
    private static int shuffleColorIndex = 0;

    private static List<Character> letters = new ArrayList<>();
    private static List<Color> colors = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(shuffleLetter());
        System.out.println(shuffleLetter());
        System.out.println(shuffleLetter());

        System.out.println(shuffleColor());
        System.out.println(shuffleColor());
        System.out.println(shuffleColor());
    }

    public static char shuffleLetter() {
        if (shuffleLetters) {
            int start = (int) 'a';
            int end = (int) 'z';
            for (int i = start; i <= end; i++) {
                letters.add(Character.valueOf((char) i));
            }
            Collections.shuffle(letters);
            shuffleLetters = false;
        }

        return letters.get(shuffleLetterIndex++);
    }

    public static Color shuffleColor() {
        if (shuffleColors) {
            colors.add(Color.RED);
            colors.add(Color.YELLOW);
            colors.add(Color.GREEN);
            colors.add(Color.BLUE);
            Collections.shuffle(colors);
            shuffleColors = false;
        }

        return colors.get(shuffleColorIndex++);
    }

}