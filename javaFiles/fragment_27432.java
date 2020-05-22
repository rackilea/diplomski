public static void printLetters(char a, char b) { //1st comment
    char temp;
    if (a > b) { // 2nd comment
        temp = a;
        a = b;
        b = temp;
    }//end if
    while (a < b) { // 3rd comment
        a++;
        System.out.println(a); // 4th comment
    }
}//end printLetters