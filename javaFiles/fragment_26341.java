try{
            File file = new File("inventory.txt");
            Scanner inFile = new Scanner(file);
            currBal = inFile.nextDouble();
            lampName = inFile.next();
            lampPrice = inFile.nextDouble();
            lampQuantity = inFile.nextInt();
            chairName = inFile.next();
            chairPrice = inFile.nextDouble();
            chairQuantity = inFile.nextInt();
            deskName = inFile.next();
            deskPrice = inFile.nextDouble();
            deskQuantity = inFile.nextInt();
            inFile.close();
        }