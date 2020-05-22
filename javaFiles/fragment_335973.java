while (sc.hasNextLine()) {

        String temp = sc.nextLine();

        if (temp.equals("")) { continue; } // <--- notice this line
        String[] tempArray = temp.split(" % ");

        System.out.println(tempArray[0]);

        // Splitting the array into its appropriate temp variables
        double payCheckAmount = Double.parseDouble(tempArray[0]);
        String paycheckDate = tempArray[1];
        String description = tempArray[2];
        boolean payCheckSplit = Boolean.parseBoolean(tempArray[3]);
        double amountUnSplit = Double.parseDouble(tempArray[4]);

    }
}