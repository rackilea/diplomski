File file = new File("salaries.txt");
        System.out.println(file.getAbsolutePath());
        while (inputFile.hasNextLine()) {
           String line = inputFile.nextLine();
           String[] lineArray = line.split(";");
           int fileAge = Integer.parseInt(lineArray[0]);
           String fileGender = lineArray[1];
           String fileEmail = lineArray[2];
           int fileSalary = Integer.parseInt(lineArray[3]);
           if (fileGender.equals("male")) {
               maleCount++;
           } else {
               femaleCount++;
            }
        }
        System.out.println(maleCount);