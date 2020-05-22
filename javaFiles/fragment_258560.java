public static void main(String[] args) {

        double length = 1;
        double width = 3;
        double height = 5;
        double resultPyramidArea = (length * width) + (length * Math.sqrt(Math.pow(width / 2, 2) +
                Math.pow(height, 2))) + (width * Math.sqrt(Math.pow(length / 2, 2) + Math.pow(height, 2)));

        System.out.println(resultPyramidArea);
    }