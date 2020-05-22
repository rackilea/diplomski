List<?> results=q.execute(names).getResults();
Iterator<List> it = results.iterate();
while(it.hasNext()){
    List ls = it.next();
    System.out.println("Id: "+ls.get(0));
}