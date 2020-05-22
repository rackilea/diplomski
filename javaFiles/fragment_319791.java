Integer value;
    if (input.matches("\\d+")) {
        value = Integer.valueOf(input);
    } else {
        value = 0;
    }