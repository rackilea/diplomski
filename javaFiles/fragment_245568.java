Map<Integer, Girl> girls = new HashMap<Integer, Girl>();

while(r.next()){
    int i = r.getInt("id"); // note the getInt()
    Girl g = girls.get(i); //attempt to get girl from map by ID, returns null if not found

    if(g==null) { // check if null
        g=new Girl(); // create
        girls.put(i,g); //put into map
    }
    g.age=r.getString("age");
    g.name=r.getString("name");
    g.id=r.getString("id");
}