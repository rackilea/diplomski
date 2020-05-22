while (scannerFile.hasNextInt()) {

            scannerFile.next();

            if(scannerFile.hasNextInt())

            {

                int i = scannerFile.nextInt();

                double cost = scannerFile.nextDouble();

                costGifts[i-1] = cost;

            }

            else
            {

                scannerFile.nextInt();

                total = scannerFile.nextLine();

            }

        }

        scannerFile.close();