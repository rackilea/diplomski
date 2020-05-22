public static void main(String[] args) {
    x("11112", "");
    System.out.println("------");
    x("163", "");
}
private static final void x(String digits, String word) {
    if (digits.isEmpty())
        System.out.println(word);
    else {
        int num = Integer.parseInt(digits.substring(0, 1));
        x(digits.substring(1), word + (char)('A' + num - 1));
        if (digits.length() >= 2 && (num = Integer.parseInt(digits.substring(0, 2))) <= 26)
            x(digits.substring(2), word + (char)('A' + num - 1));
    }
}