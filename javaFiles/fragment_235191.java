for(int r = 0; r < 7; r++){
        tempString = scnr.nextLine().split(" ");
        temp[r] = new double[tempString.length];
        for(int c = 0; c < tempString.length; c++){
            temp[r][c] = Double.parseDouble(tempString[c]);
        }
    }