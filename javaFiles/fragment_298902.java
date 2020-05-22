SimpleList<String> list = new SimpleList<String>();
    list.append("aylmao");
    list.append("1aylmao");
    list.append("2aylmao");
    list.append("3aylmao");
    list.append("4aylmao");
    list.append("5aylmao");
    list.append("6aylmao");
    Iterator<String> iter = list.iterator()
    while (iter.hasNext()) {

        System.out.println(iter.next());
    }