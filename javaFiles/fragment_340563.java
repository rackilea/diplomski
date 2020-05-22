final int len = data.length();
    for (int i = 0; i < len; i++) {
        if (data.charAt(i) <= ' ') {
            doThrow();
        }
    }