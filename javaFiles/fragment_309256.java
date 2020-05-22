private static float compare(MethodNode mn1, MethodNode mn2) {
    Type[] typeArgs1 = Type.getArgumentTypes(mn1.desc);
    Type[] typeArgs2 = Type.getArgumentTypes(mn2.desc);
    int max = Math.max(typeArgs1.length, typeArgs2.length);
    if (max == 0)
        return 1f;
    int matches = 0;
    List<Type> types = Arrays.asList(typeArgs1);
    for (Type arg : typeArgs2)
        if (types.contains(arg))
            matches++;
    return ((float) matches / max);
}