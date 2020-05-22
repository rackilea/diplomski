for (int i = 0, j = 0, n = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c == '{') {
            if (++n == 1) {
                j = i;
            }
        } else if (c == '}' && --n == 0) {
            System.out.println(input.substring(j + 1, i));
        }
    }