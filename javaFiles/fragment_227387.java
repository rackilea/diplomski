public static void main(String[] args) throws Exception {
        File myFile = new File("C:/temps.txt");

        Scanner input = new Scanner(myFile);
        String linrread = null;
        try {
            while ((linrread = input.nextLine()) != null) {
                System.out.println("linrread ."+ linrread);
                if (linrread.indexOf(",") != -1) {
                    String[] split = linrread.split(",");
                    String date = split[0];
                    String temp = split[1];
                    System.out.println("date :" + date + " temp: " + temp);
                }
            }
        } catch (NoSuchElementException t) {
            t.printStackTrace();
            System.out.println("Reached end of the file.");
        }

    }