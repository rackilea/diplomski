public String myMethod(String string1, String string2) {

    for (int i = 0; i < 25; i++) {
        B = string1 + i + string2;
        if (!B.equals("something"))
            return "Fail";  // we know the entire method should
                            // return "Fail" here
    }

    // other loops, same format

    return "Pass";  // we know nothing returned "Fail" at this point,
                    // so we return "Pass"

}