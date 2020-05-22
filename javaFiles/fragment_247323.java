List<String> list  = new ArrayList<String>();
    List<String> hashTagList  = new ArrayList<String>();

    list.add("ab");
    list.add("#SomeHash");
    list.add("qwlerkj");
    list.add("!@#!@");
    list.add("sdfs");
    list.add("#anotherhash");
    Iterator<String> listItr = list.iterator();
    while (listItr.hasNext()){
        String element =  listItr.next();
        if(element.startsWith("#")){
            hashList.add(element);
        }
    }