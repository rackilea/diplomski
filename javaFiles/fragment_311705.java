public P4_Icel_Murad_Life(String fileName) {
        Scanner in;
        try {
            Scanner s = new Scanner(new File("C:/Users/muro0/Desktop/life100.txt"));
            int rows = s.nextInt();
            int columns = s.nextInt();
            int matrix[][] = new int[rows][columns];
            while (s.hasNextInt()) {
                int row = s.nextInt();
                int col = s.nextInt(); // If this fails the text documnet is incorrect.
                matrix[row][col] = 1;
            }
            s.close();
            // At this point all dead cells are 0 and all live are 1
        } catch (IOException i) {
            System.out.println("Problems..");

        }
    }