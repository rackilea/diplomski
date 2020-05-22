// change && to ||
while(it1.hasNext() || it2.hasNext() || it3.hasNext() || it4.hasNext()) {
    Object[] objs = new String[] { "", "", "", ""}; // empty strings
    // if iterators on this row are not empty, replace with values
    if(it1.hasNext()) objs[0] = it1.next();
    if(it2.hasNext()) objs[1] = it2.next();
    if(it3.hasNext()) objs[2] = it3.next();
    if(it4.hasNext()) objs[3] = it4.next();
    // now print
    String tabs = "\t\t\t";
    System.out.println(objs[0] + tabs + objs[1] + tabs + objs[2] + tabs + objs[3]);

}