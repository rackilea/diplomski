Set<String> directoryList = new HashSet<String>() {
        {
            add("a/a1/a2/a3");
            add("b/b1/b2/b3");
            add("c/c1/c2/c3/c4");
        }
    };

    Set<String> newSet=new LinkedHashSet<String>();
    for(String i:directoryList){
        String[] str=i.split("/");
        StringBuilder sb=new StringBuilder();
        for(String s:str){
            sb.append(s);
            newSet.add(sb.toString());
            sb.append("/");
        }
    }