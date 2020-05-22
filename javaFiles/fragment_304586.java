while (in.hasNext()) {
    String s = in.next();  
    if (map.containsKey(s))
        System.out.print(s + "=" + map.get(s));
    else
        System.out.print("Not found");
    if (in.hasNext())
        System.out.println();
}