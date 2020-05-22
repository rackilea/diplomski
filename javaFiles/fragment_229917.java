for (String d: dirs){
    String [] l = d.split("/");

    int di = d.length(); // <- here

    mySort.add(new Sort(di,l,d));
}