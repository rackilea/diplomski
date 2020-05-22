public void printStars(int level) {

    for (int one = level; one >= 1; one--) {
        for(int k=1, k<one;k++){  // print appropriate number of spaces before
            System.out.print(" "); 
        }    
        for (int two = 1; two <=2*(level-one)+1; two++) {
            System.out.print("*");
        }
        System.out.println();
    }
}