for (int i = Integer.MIN_VALUE; ; i++) {
        double d = i;
        if (i != (int) d) {
            throw new IllegalStateException("i can't be converted to double and back: " + i);
        }
        if (i == Integer.MAX_VALUE) {
            break;
        }
    }