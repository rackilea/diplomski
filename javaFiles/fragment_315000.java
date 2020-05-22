public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("test.txt"));
        while (reader.hasNextLine()) {
            int nextInt = reader.nextInt();
            if (nextInt != -999)
                System.out.print(nextInt + " ");
            else
                System.out.println();
        }
    }