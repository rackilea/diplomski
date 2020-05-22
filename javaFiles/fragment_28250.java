public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String 1: ");
    String A1 = sc.nextLine();

    MaxRepeat(A1);
}

public static void MaxRepeat(String A) {
    int count = 1;
    int max1 = 1;
    char mostrepeated1 = ' ';
    for(int i = 0; i < A.length()-1;i++) {
        char number = A.charAt(i);

        if(number == A.charAt(i+1)) {
            count++;
            if(count>max1) {
                max1 = count;
                mostrepeated1 = number;
            }
            continue;
        }
            count = 1;
    }

    count = 1;
    int max2 = 1;
    char mostrepeated2 = ' ';
    for(int i = A.length()-1; i>0; i--) {
        char number = A.charAt(i);

        if(number == A.charAt(i-1)) {
            count++;
            if(count>max2) {
                max2 = count;
                mostrepeated2 = number;
            }
            continue;
        }
            count = 1;
    }

    if((max1==max2) && (mostrepeated1==mostrepeated2)) {
        System.out.println("Most Consecutively repeated character is: " + mostrepeated1 + " and is repeated " + max1 + " times.");
    }

    else if((max1==max2) && (mostrepeated1!=mostrepeated2)) {
        System.out.println("Most continously repeated characters are: " + mostrepeated1 + " and " + mostrepeated2 + " and they are repeated " + max1 + " times");
    }
}