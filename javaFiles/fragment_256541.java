Set<String>  set=new HashSet<>();
    while (true){
        String s=new String("test");
        set.add(s);
        if(set.size()==100){
            final Set<String> temp=new HashSet<>(set);   //line 1
            set.clear();;
        }
    }