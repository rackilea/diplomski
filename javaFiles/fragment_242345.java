for(myObj obj : allobjects){
    List<myObj> list = map.get(obj);
    if(list == null){
        list = new ArrayList<myObj>();
        map.put(obj, list);
    }
    list.add(obj);
}