List<Integer> list = new ArrayList<>();
outer:
for (String num : "1 23 35 5d 8 0 f".split(" ")) {
    for (int i = 0; i < num.length(); i++) {
        char c = num.charAt(i);
        if (!((c >= '0' && c <= '9') || c == '-' || c == '+')) continue outer;
    }
    try {
        list.add(Integer.parseInt(num));
    } catch (NumberFormatException e) {}
}