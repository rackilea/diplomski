Integer value;
    try{
        value = Integer.valueOf(input);
    } catch(NumberFormatException ignored) {
        value = 0;
    }