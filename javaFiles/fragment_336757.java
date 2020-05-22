Set<String> set = new ConcurrentSkipListSet<>(
        Comparator.comparing(String::length).reversed()
        .thenComparing(s -> s));

set.add("aa");
set.add("bb");
set.add("aaa");
set.add("ccc");
System.out.println(set);