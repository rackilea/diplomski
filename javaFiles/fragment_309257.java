private static float compare(MethodNode mn1, MethodNode mn2) {
    Type t1 = Type.getMethodType(mn1.desc);
    Type t2 = Type.getMethodType(mn2.desc);
    Type[] targs1 = t1.getArgumentTypes();
    Type[] targs2 = t2.getArgumentTypes();
    int max = Math.max(targs1.length, targs2.length);
    int matches = 0;
    if (max == 0) 
        return 1f;
    List<String> types1 = new ArrayList<String>();
    for (Type t : targs1) 
        types1.add(t.getDescriptor());
    for (Type t : targs2) 
        if (types1.contains(t.getDescriptor())) 
            matches++;  
    return (1F * matches / max);
}