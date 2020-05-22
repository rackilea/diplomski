public static void fullType(Field f) {
    AnnotatedType at = f.getAnnotatedType();
    fullType("\t", at);
    System.out.println(f.getName());
}
public static void fullType(String header, AnnotatedType at) {
    final boolean arrayType = at instanceof AnnotatedArrayType;
    if(arrayType) {
        fullType(header+"\t",
            ((AnnotatedArrayType)at).getAnnotatedGenericComponentType());
    }
    for(Annotation a: at.getAnnotations())
        System.out.println(header+a);
    if(arrayType) {
        System.out.println(header+"[]");
    }
    else if(at instanceof AnnotatedParameterizedType) {
        AnnotatedParameterizedType apt = (AnnotatedParameterizedType)at;
        System.out.println(header
            +((ParameterizedType)apt.getType()).getRawType().getTypeName());
        System.out.println(header+'<');
        String subHeader=header+"\t";
        for(AnnotatedType typeArg:
            apt.getAnnotatedActualTypeArguments())
            fullType(subHeader, typeArg);
        System.out.println(header+'>');
    }
    else if(at instanceof AnnotatedTypeVariable) {
        // when appearing in a Field’s type, it refers to Class’ type variables
        System.out.println(header+at.getType().getTypeName());
    }
    else if(at instanceof AnnotatedWildcardType) {
        System.out.println(header+"?");
        final AnnotatedWildcardType awt = (AnnotatedWildcardType)at;
        AnnotatedType[] bounds=awt.getAnnotatedLowerBounds();
        if(bounds==null || bounds.length==0) {
            bounds=awt.getAnnotatedUpperBounds();
            if(bounds==null || bounds.length==0) return;
            System.out.println(header+"extends");
        }
        else System.out.println(header+"super");
        header+="\t";
        for(AnnotatedType b: bounds) fullType(header, b);
    }
    else {
        assert at.getType().getClass()==Class.class;
        System.out.println(header+at.getType().getTypeName());
    }
}