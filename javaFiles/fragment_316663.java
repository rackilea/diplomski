public static int[][] deepCopyArray(int[][] oldArray){
        int[][] newArray = new int[oldArray.length][];
        for(int i=0; i<oldArray.length; i++)
        {
            newArray[i] = new int[oldArray[i].length];
            for(int j=0; j<oldArray[i].length; j++)
                newArray[i][j] = oldArray[i][j];
        }
        return newArray;
    }