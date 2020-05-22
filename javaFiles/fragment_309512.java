public String toUpperCase() {
    StringBuilder upperCase = new StringBuilder(letters.length);
    for (char c : letters) {
        upperCase.append(Character.toUpperCase(c));
    }
    return upperCase.toString();
}