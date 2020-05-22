String a1 = "aPplE";
char[] s1 = a1.toCharArray();
int diff = 'a' - 'A';

for (int i=0; i < s1.length; i++) {
    if (s1[i] >= 'A' && s1[i] <= 'Z') {
        s1[i] += diff;
    }
}

System.out.println(s1);

apple