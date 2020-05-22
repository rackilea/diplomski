QueryResult result = engine.query(query,params);

//Save iterator
Iterator i = result.iterator();

while(i.hasNext()) {
    HashMap res = (HashMap)i.next();
    Node node   = (Node)res.get("n");
    results.add(new BusyProfile(node));
}