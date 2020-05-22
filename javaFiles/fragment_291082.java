public List<String> getKeyRange(Integer start, Integer end) {
    List<String> list = new ArrayList<String>();

    for (int i = start; i < end; i++) {
        String value = map.get(i); //Forgot that string can be null in Java

        if (value != null)
            list.add(value);
    }

    return list;
}