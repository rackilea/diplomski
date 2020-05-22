public static void iterate(int start, int end) {
    int inc = (start < end) ? 1 : -1;

    end += inc; //Allow to include the value.

    do {
        System.out.print(start);

        start += inc;

        if(start != end){
            System.out.print(", ");
        }
    } while (start != end);
    System.out.println();
}