outer: for (String str1 : list1) {
    for (String str2: list2) {
        if (str2.contains(str1)) {
            continue outer;
        }
    }

    list2.add(str);
}