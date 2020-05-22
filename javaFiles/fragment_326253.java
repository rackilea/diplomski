public void printPattern(int n) {
    printHelper(n, n);
}

public void printHelper(int n, int initialSize) {
    if(n > 0) {
        printHelper(n - 1, initialSize);
    }

    System.out.print(stringHelper("*", n));
    System.out.println(stringHelper("-", initialSize - n));
}

public String stringHelper(String string, int length) {
    if (length == 0) {
        return "";
    }

    if (string.length() == length) {
        return string;
    }

    return stringHelper(string + string.charAt(0), length);
}