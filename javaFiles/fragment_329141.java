int counter = 0;
    boolean top_to_bottom=true;
    for (int j = 0; j < columns; j++){
        for (int i = 0; i < rows; i++) {
            counter++;
            if(top_to_bottom)
             array[i][j]=counter;
            else
             array[rows-1-i][j]=counter;
        }
        if(top_to_bottom)
         top_to_bottom=false;
        else top_to_bottom=true;
    }