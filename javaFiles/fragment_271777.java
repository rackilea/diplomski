String[] strings = new String[] {
    "aaa", "bbb", "ccc", "ddd"
};

Collections.shuffle(Arrays.asList(strings));

String p = strings[0],
       q = strings[1],
       r = strings[2],
       s = strings[3];