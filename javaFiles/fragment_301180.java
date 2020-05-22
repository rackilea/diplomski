int i = 0;
   while(i < arraysizex * arraysizey) {
        x = (int) (Math.random() * arraysizex);
        y = (int) (Math.random() * arraysizey);
        if (array[x][y] == 0) {
            array[x][y] = 1;
            i++;
            //do something
        }
    }