String string1 = "abc";
    String string2 = "aba";

    int l = string1.length();
    boolean flag = false;
    int i = 0;

    while (true) {
        if (l > string2.length() && !flag) {
            break;
        }
        if (string1.equals(string2.substring(i, l))) {
            flag = true;
            break;
        }
        i++;
        l++;
    }

    if (flag)
        System.out.println("Contains");
    else
        System.out.println("Does not Contain");