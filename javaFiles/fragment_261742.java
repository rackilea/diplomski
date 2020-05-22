public static void main(String[] args) {
    //Sysout for example only
    System.out.println(filterPhone("8889990000"));
    System.out.println(filterPhone("888-999-3333"));
    System.out.println(filterPhone("888B999A3333"));
    System.out.println(filterPhone(""));
}

public static boolean filterPhone(String phone_text) {
    boolean correct;

    if ((phone_text.length() <= 12) && (phone_text.matches("^[0-9-]+$")))
        correct = true;
    else
        correct = false;

    System.out.println("correct =" + correct);
    return correct;

    // InputFilter lengthFilter = new InputFilter.LengthFilter(12);
}