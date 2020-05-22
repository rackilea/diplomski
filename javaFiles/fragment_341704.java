String str="Lorem ipsum word <tag> 1,2,3,4 </tag> dolor sit amen";
    String tag=str.substring(str.indexOf("<tag>") + "<tag>".length());
    tag = tag.substring(0, tag.indexOf("</tag>")).trim();

    String[] ints = tag.split(",");

    List<Integer> list = new ArrayList<Integer>();
    for (String s : ints) {
        list.add(Integer.valueOf(s));
    }
    System.out.println(list);