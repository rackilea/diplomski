package com.stringrelatedfunction;

public class StringTaskOnComprassion2 {

    private String s1;
    private String s2;

    public StringTaskOnComprassion2(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    public static void main(String[] args) {
        String s1 = "Same Different same differentAgain inSquareBraces  ";
        String s2 = " Same different   same   DifferentAgain     inFlowerBraces ";
        StringTaskOnComprassion2 sc = new StringTaskOnComprassion2(s1, s2);
        System.out.println(sc.compareString());
    }
    public String compareString() {
        s1 = s1.replaceAll("\\s{2,}", " ").trim();
        s2 = s2.replaceAll("\\s{2,}", " ").trim();
        String str1[] = s1.split(" ");
        String str2[] = s2.split(" ");
        String temp = "";

        int min = ((str1.length <= str2.length) ? (str1.length) : (str2.length));
        int max = ((str1.length >= str2.length) ? (str1.length) : (str2.length));

        for (int i = 0; i < max; i++) {
            if (i < min) {
                temp += (str1[i].equals(str2[i]) ? (str1[i] + " ") : ("[" + str1[i] + "]" + " " + "{" + str2[i] + "}"+" "));
            } else if (max == str1.length) {
                temp += ("[" + str1[i] + "]" + " ");
            } else {
                temp += ("{" + str2[i] + "}" + " ");
            }
        }
        return temp;
    }
}



/*output:
Same [Different] {different} same [differentAgain] {DifferentAgain} [inSquareBraces] {inFlowerBraces} 
*/