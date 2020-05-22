boolean isPhone(String check) {
    float firstHyphen = check.indexOf("-");
    char[] numbers = check.toCharArray();
    float check2 = numbers.length / 3;
    if (firstHypen.equals(check2)) {
        return true;
    }
    return false;
}