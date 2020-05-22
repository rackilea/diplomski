List<Integer> list = new ArrayList<>();
for (String num : "1 23 35 5d 8 0 f".split(" ")) {
    try {
        list.add(Integer.parseInt(num));
    } catch (NumberFormatException e) {}
}