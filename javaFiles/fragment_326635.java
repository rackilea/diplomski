Map<Long, ArrayList<String>> data = new HashMap<Long, ArrayList<String>>();
// where T is the type of your object
for (T t : list) {
    if (!data.containsKey(t.messageFrom)) {
        data.put(t.messageFrom, new ArrayList<String>());
    }
    data.get(t.messageFrom).add(t.message);
}