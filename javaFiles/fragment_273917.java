while (a<10000) {
    String str1 = String.valueOf(a);
    // problem: move first char to last;
    String str2 = "10"; // example; convert to int and store in b for calculation;

    // this takes the first character of str1 and moves it to 
    // end of str2.

    // 1. Make a copy first
    char first = str1.charAt(0);
    // 2. Now remove the character and assign to str2
    str2 = str1.substring(1);
    // 3. Place the saved copy at the end
    str2 = str2 + first;

    b = Integer.parseInt(str2);

    c = a - b;

    if (c > difference)
        System.out.println(c);
    else
        a++;