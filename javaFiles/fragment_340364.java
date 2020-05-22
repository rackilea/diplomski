public static int diagonalWalk(int sizex, int sizey, boolean showSteps) {
    int posx = 0;
    int posy = 0;
    int sum = 1;
    int deltay = 1;
    int deltax = 1;
    sizex--;//valid cols are: 0 - sizex-1
    sizey--;//valid rows are: 0 - sizey-1
    if (showSteps) {
        System.out.println("At: 0/0:1");
    }
    do {
        posx += deltax;
        posy += deltay;
        sum += Math.pow(2, posx) * Math.pow(2, posy);
        if (showSteps) {
            System.out.println("At: " + posy + "/" + posx + ":" + Math.pow(2, posx) * Math.pow(2, posy));
        }

        //wallhit left or right
        if (posx == 0 || posx >= sizex) {
            deltax = -deltax;
        }
        //wallhit top or bottom
        if (posy == 0 || posy >= sizey) {
            deltay = -deltay;
        }
    }while(!((posx == 0 || posx >= sizex) && (posy == 0 || posy >= sizey)));
    return sum;
}

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    int sum = diagonalWalk(3,4, true);
    System.out.println("result is:" + sum);
}