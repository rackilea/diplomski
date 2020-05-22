public void loadGame() throws FileNotFoundException{

       //your code here ........
        for (int i = 1; i < grid_height-1; i++) {
            for (int j = 1; j <= grid_width-1; j++) {
                    if(reader.hasNext()){
                         int next = reader.nextInt(); //save the return value and use it for comparision

                         if (next == 1){game[i][j].setIcon(p1);}
                         if (next  == 2){game[i][j].setIcon(p2);} 
                         else if(next  == 0){game[i][j].setIcon(null);
                    } //close the if loop
        //rest of your code here .......