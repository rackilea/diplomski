public static String concateAndAppend(String data1, String data2) {
    char[] str1 = data1.toCharArray();
    char[] str2 = data2.toCharArray();
    String result = "";

    //we must iterate to the length of the smaller string
    //if you don't calculate the smaller size you might
    //get indexOutOfBounds Exceptions, i.e. you try to access
    //non-existant indexes in the arrays
    int minimum = Math.min(str1.length, str2.length); //calculate minimum between the two array lenghts

    //append the characters on the same index to the result
    //starting with str1 from left
    for (int i = 0; i < minimum; i++) {
        result = result + str1[i] + str2[i];
    }

    //now you must pad the results to include the bigger string
    //since you only iterated minimum index positions.

    //check which string is bigger then append accordingly
    if (str1.length > minimum) {
        result = result + data1.substring(minimum); //substring to only append the part after the minimum index
    } else if (str2.length > minimum) {
        result = result + data2.substring(minimum);//substring to only append the part after the minimum index
    }

    return result;
}

public static void main(String[] args) {

    String s1 = "Hello Hi";
    String s2 = "World of Mine";

    System.out.println(concateAndAppend(s1, s2));
}