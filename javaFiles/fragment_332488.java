for (int i = 1; i <= name1.length() || i <= name2.length(); i++) {
    if (i <= name1.length()) {
        temp += name1.charAt(i - 1);
    }
    if (i <= name2.length()) {
        temp += name2.charAt(name2.length() - i);
    }
}