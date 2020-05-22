private static void rperm(char[] cs, char[] result, int level) {
    if (level == result.length) {
        System.out.println(j++ + " " + new String(result));
        return;
    }

    for (int i = 0; i < cs.length; i++) {
        if (cs[i] != 0) {
            // first, determine if the current char was already 
            // encountered among the available options
            boolean encountered = false;
            for (int j = 0; j < i; j++) {
                if (cs[j] == cs[i]) {
                    encountered = true;
                    break;
                }
            }

            if (!encountered) {
                result[level] = cs[i];
                char temp = cs[i];
                cs[i] = 0;
                rperm(cs, result, ++level);
                cs[i] = temp;
                level--;
            }
        }
    }
}