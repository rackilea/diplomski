List<String> lists = new ArrayList<String>();
for (String list : words) {
    list.trim();
    ArrayList<String> answer = new ArrayList<String>();
    f(list, "", answer);
    lists.addAll(answer);
}