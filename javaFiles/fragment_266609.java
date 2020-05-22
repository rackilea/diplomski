public static void readFromFile() {
        double average = 0;
        while (input.hasNextInt()) {
            int token = input.nextInt();
            average+=token;
        }
        System.out.println("Average ="+average/10);
}