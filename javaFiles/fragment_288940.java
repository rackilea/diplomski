//Try this:

public static void main(String[] args) {

...
StringCompare compare = new StringCompare();
compare.compareStrings(s1,s2);

}

public void compareStrings(String s1, String s2) {


        if (s1.equals(s2)) {
            System.out.println("The strings are equal!");
        } else {
            System.out.println("The strings are not equal!");
        }
    }