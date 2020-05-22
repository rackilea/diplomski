int[] year = new int [lineCount];
        String[] quarter = new String [lineCount];
        int[] sale = new int [lineCount];

        Scanner readFile = new Scanner(new File("sales.txt"));

        while(readFile.hasNextLine())
        {
            String salesRecords = readFile.nextLine();
            Scanner lineScan = new Scanner(salesRecords);
            lineScan.useDelimiter(",");
            year[i] = lineScan.nextInt();
            quarter[i] = lineScan.next();
            sale[i] = lineScan.nextInt();
            lineScan.close();
            i++;
        }