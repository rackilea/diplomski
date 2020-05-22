public Node search(String key){
    for(Node n = first; n != null; n = n.next)
        if(isEqu(n.data, key))
            return n;
    return null;
}

private static boolean isEqu(Object o1, Object o2) {
    return o1 == null ? o2 == null : o1.equals(o2);
}