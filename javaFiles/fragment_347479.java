double [] myArray = new double [100];
        int count = 0;
        double min = myArray[0];
        double max = myArray[0];

        //Read numbers from file, add to array and determine min/max values
        while(in.hasNextDouble()) {
            myArray[count] = in.nextDouble();
            //sentinel
            if(myArray[count]==-1.0)
                break;
            if(myArray[count] < min) {
                min = myArray[count];
            }
            if(myArray[count] > max) {
                max = myArray[count];
            }
            count++;
        }

        //Calculate and print weighting

        for(int index = 0; index < count; index++) {//<-----NOTE HERE: as the array is filled upto "count"
            double num = myArray[index];
            double weighting = (num - min) / (max - min);
            System.out.printf("%8.4f %4.2f\n", num, weighting);
        }