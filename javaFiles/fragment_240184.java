package org.example;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {
    private static final Path INPUT_FILE_PATH = Paths.get("./resources/longnums.txt");
    private static final Path OUTPUT_FILE_PATH = Paths.get("./answers/p5a.txt");

    public static List<BigInteger> readDataFromFile() throws IOException {
         return Files.readAllLines(INPUT_FILE_PATH).stream().map(BigInteger::new).collect(toList());
    }

    public static String calculateFirst10DigitsOfSum(List<BigInteger> numbers) {
        BigInteger sum = numbers.stream().reduce(BigInteger.ZERO, (a,b) -> a.add(b));
        return sum.toString().substring(0, 10);
    }

    public static void writeLinesSortedToFile(List<BigInteger> numbers) throws IOException {
        List<String> outputLines = numbers.stream().sorted().map(BigInteger::toString).collect(toList());
        Files.write(OUTPUT_FILE_PATH, outputLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
    }

    public static void main(String[] args) throws IOException {
        List<BigInteger> data = readDataFromFile();
        writeLinesSortedToFile(data);
        String first10Digits = calculateFirst10DigitsOfSum(data);
        System.out.println(first10Digits);
    }
}