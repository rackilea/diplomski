for (String[] tmpArray: array1) {
        if(tmpArray.length == 1)
        { 
            System.out.println(tmpArray[0]);
            continue;
        }
        for (int i = 1; i < tmpArray.length; i++)  {
            System.out.println(tmpArray[0] + " " + tmpArray[i]);
        }
    }