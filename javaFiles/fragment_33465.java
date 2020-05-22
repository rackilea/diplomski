public static void method(String... strs) {
    for (String s : strs)
        System.out.println(s);
}

...
    List<String> strs = new ArrayList<String>();
    strs.add("hello");
    strs.add("wordld");

    method(strs.toArray(new String[strs.size()]));
    //     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
...