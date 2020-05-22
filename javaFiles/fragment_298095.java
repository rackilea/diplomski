package com.ggl.testing;

public class PrintBytes {

    public static void main(String[] args) {
        long bytes = 13845487616L;
        System.out.println(bytes + " -> " + convertBytes(bytes));
        bytes = 91357184000L;
        System.out.println(bytes + " -> " + convertBytes(bytes));
        bytes = 123L;
        System.out.println(bytes + " -> " + convertBytes(bytes));
        bytes = 1234L;
        System.out.println(bytes + " -> " + convertBytes(bytes));
        bytes = 123456789L;
        System.out.println(bytes + " -> " + convertBytes(bytes));
    }

    public static String convertBytes(long bytes) {
        long kbDivisor = 1024L;
        long mbDivisor = kbDivisor * kbDivisor;
        long gbDivisor = mbDivisor * kbDivisor;

        if (bytes <= mbDivisor) {
            double kb = (double) bytes / kbDivisor;
            return String.format("%.2f", kb) + " KB";
        } else if (bytes <= gbDivisor) {
            double mb = (double) bytes / mbDivisor;
            return String.format("%.2f", mb) + " MB";
        } else {
            double gb = (double) bytes / gbDivisor;
            return String.format("%.2f", gb) + " GB";
        }

    }

}