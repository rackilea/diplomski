public class DemoApplicationTests {

public static void main(String args[]) throws Exception {

    String str1 = "eat";
    int len = str1.length();
    char[] str = str1.toCharArray();
    recurPerm(str, 0, len);
}

static void recurPerm(char[] str, int strstartind, int sz) {

    for (int i = strstartind; i < sz; i++) {
        char temp = str[strstartind];
        str[strstartind] = str[i];
        str[i] = temp;
        recurPerm(str, strstartind + 1, sz);
        //restore state
        str[i] = str[strstartind];
        str[strstartind] = temp;
    }
    if (strstartind >= sz) {
        System.out.println(str);
    }

    return;
}
}