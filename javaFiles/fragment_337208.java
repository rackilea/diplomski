int totals[5][3];
for(int x = 0;x<5;x++){
    for(int y = 0;y<5;y++){
        int total = data[x][y]
        if(x>0){
            total+=  data[x-1][y];
        }
        if(x<4){
            total+=  data[x+1][y];
        }
        if(y>0){
            total+=  data[x][y-1];
        }
        if(y<2){
            total+=  data[x][y+1];
        }
        totals[x][y] = total;
    }
}