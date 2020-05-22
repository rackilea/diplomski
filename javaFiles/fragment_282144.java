public static void main(String[] args) {
    System.out.println('"' + printStr("College", 2) + '"');
    System.out.println('"' + printStr("Lehman", 2) + '"');
    System.out.println('"' + printStr("The Bronx", 4) + '"');
}
public static String printStr(String s, int n) {
    if (n == 1)
        return s;
    return s + ' ' + printStr(s, n - 1);
}