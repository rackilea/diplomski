String line = input.nextLine();
    try {
        String[] tokens = line.split("\\s+");
        int empNum = Integer.parseInt(tokens[0]);
        String fName = tokens[1];
        String lName = tokens[2];
        double avgHrs = Double.parseDouble(tokens[3]);
        double hrWage = Double.parseDouble(tokens[4]);
        //.......
    }
    catch (InputMismatchException e) {
        output.println(line);     //outputs invalid information to error file
    }