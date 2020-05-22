Pattern p = Pattern.compile("(\\p{Lu}[\\p{L} ]+)(\\d+[\\.]?\\d+)*|[\\S&&[^.]]+");
    Matcher m = p.matcher("Stack Careers 2.0 is the new number 1 site with symbol ! and \n* and blablabla\n replacing older Stack Careers.");
    List<String> list = new ArrayList<String>(); 
    while (m.find()) {
        list.add(m.group());
    }
    System.out.println(list);