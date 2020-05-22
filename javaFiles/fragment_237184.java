void print(TypeMirror type, Map<TypeVariable,TypeMirror> substitution)

    if(substitution.containsKey(type)) // type is a var, E
        print( substitution.get(type) ); // String

    else if(type instanceof DeclaredType) // e.g. List<E>
        print( type.asElement().getSimpleName() );  // List
        for(TypeMirror arg : type.getTypeArguments() ) // E
            print(arg, substitution)

    etc. something like that