//you can change Input No Here.
    int INPUT = 5;

    //statics for direction type 
    final int LEFT = 1;
    final int DOWN = 2;
    final int RIGHT = 3;
    final int UP = 4;

    //Grid Array
    int[][] patt = new int[INPUT][INPUT];

    //initial position 
    int x = 0;
    int y = 0;

    //initial direction
    int Direction = LEFT;

    //Master Loop
    for (int i = 0; i < INPUT * INPUT; i++) {

        int temp = i + 1;

        //Checking boundaries
        if (y > INPUT - 1) {
            Direction = DOWN;
            x++;
            y--;
            i--;
            continue;
        } else if (x > INPUT - 1) {
            Direction = RIGHT;
            x--;
            y--;
            i--;
            continue;
        } else if (y < 0) {
            Direction = UP;
            y++;
            x--;
            i--;
            continue;
        }else if (x < 0) {
            Direction = LEFT;
            y++;
            x++;
            i--;
            continue;
        }

        if (patt[x][y] == 0) {
            patt[x][y] = temp;
        } else {
            if (Direction == LEFT) {
                Direction = DOWN;
                y--;
            } else if (Direction == DOWN) {
                Direction = RIGHT;
                x--;
            } else if (Direction == RIGHT) {
                Direction = UP;
                y++;
            } else {
                Direction = LEFT;
                x++;
            }
            i--;
        }

        switch (Direction) {
        case LEFT:
            y++;
            break;
        case DOWN:
            x++;
            break;
        case RIGHT:
            y--;
            break;
        case UP:
            x--;
            break;
        }
    }// Master Loop Ends

    // Print Grid Array
    for (int i = 0; i < INPUT; i++) {
        for (int k = 0; k < INPUT; k++)
            if (patt[i][k] <= 9)
                System.out.print(" "+patt[i][k] + " ");
            else
                System.out.print(patt[i][k] + " ");
        System.out.println();
    }