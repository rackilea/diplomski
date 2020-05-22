public static void main(String[] args) {

    int startAt = 2;
    int i = startAt;

    while (i <= 10){
        int j = startAt; 

        while (j <= 10) {
            // Notice these lines are swapped!
            System.out.print(i*j + "\t");
            j+=2;
        }

        System.out.println();
        i+=2; 
    }
}