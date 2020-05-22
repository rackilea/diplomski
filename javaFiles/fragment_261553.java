List<String> list = new ArrayList<String>();
    Iterator<String> itr  = list.iterator();
    while(itr.hasNext()){
        String str = itr.next();
        //remove item based on some condition.
        itr.remove();
    }