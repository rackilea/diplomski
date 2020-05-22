List<String[]> list = new ArrayList();
try {
    list.add(new String[]{"a","b"});
    list.add(new String[]{"c","d"});

    for (String[] str: list) {
        System.out.println(Arrays.toString(str));
    }
} catch (Exception e) {}