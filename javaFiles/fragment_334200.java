//set on the max possible (every value should be less than that)
    int min=Integer.MAX_VALUE;
    //set on the min possible (every value should be more than that)
    int max=Integer.MIN_VALUE;
    //iteration through 1st index (eg. iteration through rows)
    for (int i = 0; i < array.length; i++) {
        //iteration through 2nd index of 1st index (eg. through all columns)
        for (int j = 0; j < array[i].length; j++) {
            //compare and assign if array value is less than actual found min
            if(min > array[i][j]){
                min = array[i][j];
            }
            //compare and assign if array value is more than actual found max
            if(max < array[i][j]){
                max = array[i][j];
            }
        }
    }