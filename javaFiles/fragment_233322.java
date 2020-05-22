try {
    String[] ipArr = ip.split(Pattern.quote("."));
    for (int i = 0; i < ipArr.length; i++) {
        parts[i] = Integer.parseInt(ipArr[i]);
    }
} catch (NumberFormatException e) {
    parts = new int[4];
}