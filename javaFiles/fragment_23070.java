int i = 0;
        while (scannerFile.hasNextDouble()) {


                double cost = scannerFile.nextDouble();
                costGifts[i] = cost;                    
                i++;                    
                total += cost;                                               

        }

        scannerFile.close();

    }