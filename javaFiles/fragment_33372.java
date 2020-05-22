public static boolean fullCheck(char[] toTest, char[][] g) {
    int val = checkOnAll(0, toTest, g);

    if (val == toTest.length) {
        return true;
    }
    return false;
}

public static int checkOnAll(int charPos, char[] toTest, char[][] g) {
    for(int i = 0; i < g.length; i++) {
        int val = checkOne(charPos, toTest, g[i], g);
        if (val != -1) {
            return val;
        }
    }
    return -1;
}

//also needs length checks
public static int checkOne(int charPos, char[] toTest, char[] rule, char[][] rules) {
    for(int j = 0; j < rule.length; j++) {
        if (charPos >= toTest.length) {
            return -1;
        }
        if(rule[j] == 'S') {
            int value = checkOnAll(charPos, toTest, rules);
            if (value == -1) {
                return -1;
            } else {
                charPos = value - 1;
            }
        } else if (toTest[charPos] != rule[j]) {
            return -1;
        }
        charPos++;
    }
    return charPos;
}