public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("test.txt"));
        List<Integer> values = new ArrayList<>();
        while (reader.hasNextLine()) {
            int nextInt = reader.nextInt();
            if (nextInt != -999) {
                System.out.print(nextInt + " ");
                values.add(nextInt);
            } else {
                int sum = 0;
                for (int value : values) {
                    sum += value;
                }
                System.out.println((float) sum / values.size());
                values.clear();
            }
        }
    }