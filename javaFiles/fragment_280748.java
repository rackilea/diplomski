GRect []grect = new GRect[rows][colums];

for(int i=0; i<rows; i++){
    for (int j=0; j<colums; j++){
        grect[i][j] = new GRect(x, y, width, height);    //here x and y are the x,y coordinates of the box
                                                         // widht and height are the width and height of the box  
        add(grect[i][j]); 
    }

}