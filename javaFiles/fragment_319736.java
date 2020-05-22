package com.ggl.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleHistogram implements Runnable {

    public static void main(String[] args) {
        new TriangleHistogram().run();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<TriangleModel> triangleHistogram = readInput(scanner);

        while (triangleHistogram.size() > 0) {
            String baseString = createBaseString(triangleHistogram);
            String bottomString = createBottomString(triangleHistogram,
                    baseString.length());

            List<String> histogramStrings = new ArrayList<>();
            histogramStrings.add(bottomString);
            histogramStrings.add(baseString);
            createTriangleStrings(triangleHistogram, histogramStrings);

            displayHistogram(histogramStrings);

            triangleHistogram = readInput(scanner);
        }

        scanner.close();
    }

    private List<TriangleModel> readInput(Scanner scanner) {
        List<TriangleModel> triangleHistogram = new ArrayList<>();
        System.out.print("Enter the heights of the triangles: ");
        String inputLine = scanner.nextLine();

        if (!inputLine.trim().isEmpty()) {
            String[] triangleSizes = inputLine.split("\\s");
            for (int i = 0; i < triangleSizes.length; i++) {
                TriangleModel triangleModel = new TriangleModel(
                        Integer.parseInt(triangleSizes[i]));
                triangleHistogram.add(triangleModel);
            }
        }

        return triangleHistogram;
    }

    private String createBaseString(List<TriangleModel> triangleHistogram) {
        StringBuilder builder = new StringBuilder();

        for (TriangleModel triangleModel : triangleHistogram) {
            triangleModel.setColumns(builder);
            triangleModel.createBase(builder);
        }

        return builder.toString();
    }

    private String createBottomString(List<TriangleModel> triangleHistogram,
            int length) {
        StringBuilder builder = createStringBuilder(' ', length);

        for (TriangleModel triangleModel : triangleHistogram) {
            triangleModel.createBottom(builder);
        }

        return builder.toString();
    }

    private void createTriangleStrings(List<TriangleModel> triangleHistogram,
            List<String> histogramStrings) {
        String histogramString = "";

        do {
            String baseString = histogramStrings.get(1);
            StringBuilder builder = createStringBuilder(' ',
                    baseString.length());

            for (TriangleModel triangleModel : triangleHistogram) {
                triangleModel.createTriangle(builder);
            }

            histogramString = builder.toString();
            histogramStrings.add(histogramString);
        } while (!histogramString.trim().isEmpty());

    }

    private StringBuilder createStringBuilder(char c, int length) {
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(c);
        }

        return builder;
    }

    private void displayHistogram(List<String> histogramStrings) {
        for (int i = histogramStrings.size() - 1; i >= 0; i--) {
            String line = histogramStrings.get(i);
            System.out.println(line);
        }

        System.out.println();
    }

    public class TriangleModel {
        private final int height;

        private int leftColumn;
        private int centerColumn;
        private int rightColumn;

        public TriangleModel(int height) {
            this.height = height;
        }

        public void setColumns(StringBuilder builder) {
            this.leftColumn = builder.length() + 1;
            this.centerColumn = leftColumn + height;
            this.rightColumn = centerColumn + height;
        }

        public void createBase(StringBuilder builder) {
            builder.append('<');
            for (int i = 0; i < getBaseWidth(); i++) {
                builder.append('=');
            }
            builder.append('>');
        }

        public void createBottom(StringBuilder builder) {
            builder.setCharAt(leftColumn, '|');
            builder.setCharAt(rightColumn, '|');
        }

        public void createTriangle(StringBuilder builder) {
            if (leftColumn < rightColumn) {
                builder.setCharAt(leftColumn, '/');
                builder.setCharAt(centerColumn, '|');
                builder.setCharAt(rightColumn, '\\');

                leftColumn++;
                rightColumn--;
            } else if (leftColumn == rightColumn) {
                builder.setCharAt(centerColumn, '-');

                leftColumn++;
                rightColumn--;
            }
        }

        private int getBaseWidth() {
            return height + height + 1;
        }

    }

}