String str = "15";
    char[] cArray = str.toCharArray();

    int sum = 0;
    for (char c : cArray)
        sum += Character.digit(c, 10);