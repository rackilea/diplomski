String s = "Madam", reverse = "";
int m = s.length();

for (int i = m - 1; i >= 0; i--) {
    reverse += s.charAt(i);
}
System.out.println(reverse);

if (reverse.equalsIgnoreCase(s)) { // don't use '==' for checking equality of strings
    System.out.println(s + " is Palindrome");
} else {
    System.out.println(s + " is not Palindrome");
}