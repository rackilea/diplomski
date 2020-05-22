private static int odd(String input){
    int i = 0;
    char ch;
    int sumOdd = 0;
    while (i < 11){
        ch = input.charAt(i);
        int x = Integer.parseInt(ch.ToString());
        sumOdd = x +sumOdd;
        i += 2;
    }
    int Mx3=sumOdd*3;
    return Mx3;
}


private static int even(String input){
    int i = 1;
    char ch;
    int sumEven = 0;
    while (i < 11){
        ch = input.charAt(i);
        int x = Integer.parseInt(ch.ToString());
        sumEven = x +sumEven;
        i += 2;
    }

    return sumEven;
 }