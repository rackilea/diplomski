class Main {

public static void main(String[] args) {
    char[] charArr = new char[] { 'P', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'M', 'a', 'k', 'e', 's', ' ', 'P', 'r',
            'a', 'c', 't', 'i', 'c', 'e' };
    System.out.println(charArr);
    reverseCharArray(charArr,0);
    System.out.println(charArr);
}


public static void reverseCharArray(char[] charArr, int sorted) {


    /* Look for last space*/
    int lastSpace = -1;
    for (int i = 0; i < charArr.length; i++) { 
        if (charArr[i] == ' ') {
            lastSpace = i; 
        }
    }

    /* Grab the word and move it at the beginning of the sorted array */
    for (int i = lastSpace + 1; i < charArr.length; i++) {

        int k = i;

        while (k != sorted) {
            char tmp = charArr[k-1];
            charArr[k-1] = charArr[k];
            charArr[k] = tmp;
            k--;
        }

        sorted++;
    }


    /* At this point, the last character is a space*/
    /* Else, we've swapped all the words */
    int k = charArr.length - 1;
    if (charArr[k] != ' ') {
        return;
    }

    /* If it's a space, grab it and move it at the beginning*/
    while (k != sorted) {
        char tmp = charArr[k-1];
        charArr[k-1] = charArr[k];
        charArr[k] = tmp;
        k--;
    }
    sorted++;


    /*Recursive call on the not sorted array*/
    reverseCharArray(charArr,sorted);

}}