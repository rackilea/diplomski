short[] masks = new short[strings.size()];
    for (int i = 0; i < strings.size(); i++) {
        String str = strings.get(i);
        char[] chs = str.toCharArray();
        short mask = 0;
        for (int index = 0; index < chs.length; index++) {
            char ch = chs[index];
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                mask |= (1 << digit);
            }
        }
        masks[i] = mask;
    }