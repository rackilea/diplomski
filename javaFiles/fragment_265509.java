package com.devsaki.opensimpleexcel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.ZipFile;

public class Multithread {

    public static final char CHAR_END = (char) -1;

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String excelFile = "C:/Downloads/BigSpreadsheetAllTypes.xlsx";
        ZipFile zipFile = new ZipFile(excelFile);
        long init = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        char[] sheet1 = readEntry(zipFile, "xl/worksheets/sheet1.xml").toCharArray();
        Future<Object[][]> futureSheet1 = executor.submit(() -> processSheet1(new CharReader(sheet1), executor));
        char[] sharedString = readEntry(zipFile, "xl/sharedStrings.xml").toCharArray();
        Future<String[]> futureWords = executor.submit(() -> processSharedStrings(new CharReader(sharedString)));

        Object[][] sheet = futureSheet1.get();
        String[] words = futureWords.get();

        executor.shutdown();

        long end = System.currentTimeMillis();
        System.out.println("only read: " + (end - init) / 1000);

        ///Doing somethin with the file::Saving as csv
        init = System.currentTimeMillis();
        try (PrintWriter writer = new PrintWriter(excelFile + ".csv", "UTF-8");) {
            for (Object[] rows : sheet) {
                for (Object cell : rows) {
                    if (cell != null) {
                        if (cell instanceof Integer) {
                            writer.append(words[(Integer) cell]);
                        } else if (cell instanceof String) {
                            writer.append(toDate(Double.parseDouble(cell.toString())));
                        } else {
                            writer.append(cell.toString()); //Probably a number
                        }
                    }
                    writer.append(";");
                }
                writer.append("\n");
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Main saving to csv: " + (end - init) / 1000);
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    private static final LocalDateTime INIT_DATE = LocalDateTime.parse("1900-01-01T00:00:00+00:00", formatter).plusDays(-2);

    //The number in excel is from 1900-jan-1, so every number time that you get, you have to sum to that date
    public static String toDate(double s) {
        return formatter.format(INIT_DATE.plusSeconds((long) ((s*24*3600))));
    }

    public static String readEntry(ZipFile zipFile, String entry) throws IOException {
        System.out.println("Initialing readEntry " + entry);
        long init = System.currentTimeMillis();
        String result = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(zipFile.getInputStream(zipFile.getEntry(entry)), Charset.forName("UTF-8")))) {
            br.readLine();
            result = br.readLine();
        }

        long end = System.currentTimeMillis();
        System.out.println("readEntry '" + entry + "': " + (end - init) / 1000);
        return result;
    }


    public static String[] processSharedStrings(CharReader br) throws IOException {
        System.out.println("Initialing processSharedStrings");
        long init = System.currentTimeMillis();
        String[] words = null;
        char[] wordCount = "Count=\"".toCharArray();
        char[] token = "<t>".toCharArray();
        String uniqueCount = extractNextValue(br, wordCount, '"');
        words = new String[Integer.parseInt(uniqueCount)];
        String nextWord;
        int currentIndex = 0;
        while ((nextWord = extractNextValue(br, token, '<')) != null) {
            words[currentIndex++] = nextWord;
            br.skip(11); //you can skip at least 11 chars "/t></si><si>"
        }
        long end = System.currentTimeMillis();
        System.out.println("SharedStrings: " + (end - init) / 1000);
        return words;
    }


    public static Object[][] processSheet1(CharReader br, ExecutorService executorService) throws IOException, ExecutionException, InterruptedException {
        System.out.println("Initialing processSheet1");
        long init = System.currentTimeMillis();
        char[] dimensionToken = "dimension ref=\"".toCharArray();
        String dimension = extractNextValue(br, dimensionToken, '"');
        int[] sizes = extractSizeFromDimention(dimension.split(":")[1]);
        br.skip(30); //Between dimension and next tag c exists more or less 30 chars
        Object[][] result = new Object[sizes[0]][sizes[1]];

        int parallelProcess = 8;
        int currentIndex = br.currentIndex;
        CharReader[] charReaders = new CharReader[parallelProcess];
        int totalChars = Math.round(br.chars.length / parallelProcess);
        for (int i = 0; i < parallelProcess; i++) {
            int endIndex = currentIndex + totalChars;
            charReaders[i] = new CharReader(br.chars, currentIndex, endIndex, i);
            currentIndex = endIndex;
        }
        Future[] futures = new Future[parallelProcess];
        for (int i = charReaders.length - 1; i >= 0; i--) {
            final int j = i;
            futures[i] = executorService.submit(() -> inParallelProcess(charReaders[j], j == 0 ? null : charReaders[j - 1], result));
        }
        for (Future future : futures) {
            future.get();
        }

        long end = System.currentTimeMillis();
        System.out.println("Sheet1: " + (end - init) / 1000);
        return result;
    }

    public static void inParallelProcess(CharReader br, CharReader back, Object[][] result) {
        System.out.println("Initialing inParallelProcess : " + br.identifier);

        char[] tokenOpenC = "<c r=\"".toCharArray();
        char[] tokenOpenV = "<v>".toCharArray();

        char[] tokenAttributS = " s=\"".toCharArray();
        char[] tokenAttributT = " t=\"".toCharArray();

        String v;
        int firstCurrentIndex = br.currentIndex;
        boolean first = true;

        while ((v = extractNextValue(br, tokenOpenC, '"')) != null) {
            if (first && back != null) {
                int sum = br.currentIndex - firstCurrentIndex - tokenOpenC.length - v.length() - 1;
                first = false;
                System.out.println("Adding to : " + back.identifier + " From : " + br.identifier);
                back.plusLength(sum);
            }
            int[] indexes = extractSizeFromDimention(v);

            int s = foundNextTokens(br, '>', tokenAttributS, tokenAttributT);
            char type = 's'; //3 types: number (n), string (s) and date (d)
            if (s == 0) { // Token S = number or date
                char read = br.read();
                if (read == '1') {
                    type = 'n';
                } else {
                    type = 'd';
                }
            } else if (s == -1) {
                type = 'n';
            }
            String c = extractNextValue(br, tokenOpenV, '<');
            Object value = null;
            switch (type) {
                case 'n':
                    value = Double.parseDouble(c);
                    break;
                case 's':
                    try {
                        value = Integer.parseInt(c);
                    } catch (Exception ex) {
                        System.out.println("Identifier Error : " + br.identifier);
                    }
                    break;
                case 'd':
                    value = c.toString();
                    break;
            }
            result[indexes[0] - 1][indexes[1] - 1] = value;
            br.skip(7); ///v></c>
        }
    }

    static class CharReader {
        char[] chars;
        int currentIndex;
        int length;

        int identifier;

        public CharReader(char[] chars) {
            this.chars = chars;
            this.length = chars.length;
        }

        public CharReader(char[] chars, int currentIndex, int length, int identifier) {
            this.chars = chars;
            this.currentIndex = currentIndex;
            if (length > chars.length) {
                this.length = chars.length;
            } else {
                this.length = length;
            }
            this.identifier = identifier;
        }

        public void plusLength(int n) {
            if (this.length + n <= chars.length) {
                this.length += n;
            }
        }

        public char read() {
            if (currentIndex >= length) {
                return CHAR_END;
            }
            return chars[currentIndex++];
        }

        public void skip(int n) {
            currentIndex += n;
        }
    }


    public static int[] extractSizeFromDimention(String dimention) {
        StringBuilder sb = new StringBuilder();
        int columns = 0;
        int rows = 0;
        for (char c : dimention.toCharArray()) {
            if (columns == 0) {
                if (Character.isDigit(c)) {
                    columns = convertExcelIndex(sb.toString());
                    sb = new StringBuilder();
                }
            }
            sb.append(c);
        }
        rows = Integer.parseInt(sb.toString());
        return new int[]{rows, columns};
    }

    public static int foundNextTokens(CharReader br, char until, char[]... tokens) {
        char character;
        int[] indexes = new int[tokens.length];
        while ((character = br.read()) != CHAR_END) {
            if (character == until) {
                break;
            }
            for (int i = 0; i < indexes.length; i++) {
                if (tokens[i][indexes[i]] == character) {
                    indexes[i]++;
                    if (indexes[i] == tokens[i].length) {
                        return i;
                    }
                } else {
                    indexes[i] = 0;
                }
            }
        }

        return -1;
    }

    public static String extractNextValue(CharReader br, char[] token, char until) {
        char character;
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while ((character = br.read()) != CHAR_END) {
            if (index == token.length) {
                if (character == until) {
                    return sb.toString();
                } else {
                    sb.append(character);
                }
            } else {
                if (token[index] == character) {
                    index++;
                } else {
                    index = 0;
                }
            }
        }
        return null;
    }

    public static int convertExcelIndex(String index) {
        int result = 0;
        for (char c : index.toCharArray()) {
            result = result * 26 + ((int) c - (int) 'A' + 1);
        }
        return result;
    }
}