public static void main(String[] args) {
    String input = "[1] ,[2,4], [1,2,3] ,[12,42]...";
    int start = -1;
    StringBuilder builder = new StringBuilder();
    for (int idx = 0; idx < input.length(); idx++) {
        char c = input.charAt(idx);
        if (start == -1) {
            if (Character.isDigit(c)) {
                start = idx;
            } else {
                builder.append(c);
            }
        } else if (!Character.isDigit(c)) {
            builder.append(valueOf(input.substring(start, idx)) + c);
            start = -1;
        }
    }
    if (start != -1) {
        builder.append(valueOf(input.substring(start, input.length())));
    }
    System.out.println(builder);
}

private static String valueOf(String num) {
    int val = Integer.parseInt(num);
    return map.getOrDefault(val,"**" + val + "**");
}