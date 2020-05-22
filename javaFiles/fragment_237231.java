package com.sial.workarounds;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.stream.Collectors;
    public class Zahlenstatistik {

    public static void main(String[] args) throws IOException {
        File f = new File("test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String numbers = String.join("\n", reader.lines().collect(Collectors.toList()));
        reader.close();
        Integer max = Integer.MIN_VALUE;
        int i = 0;
        String[] alle_zahlen = numbers.split("\n");

        for (i = 0; i < alle_zahlen.length; i++)
            if (max < Integer.parseInt(alle_zahlen[i]))
                max = Integer.parseInt(alle_zahlen[i]);

        System.out.println("Die groeste Zahl ist: " + max);

    }
}