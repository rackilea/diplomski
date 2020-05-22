public static Class flatten( Class classToFlatten ) {

    for ( Field f : classToFlatten.getDeclaredFields() ) {

        Class type = f.getType();
        String name = f.getName();
        int modifiersConfig = f.getModifiers();

        // extract all modifiers here (using the isXXX methods of the Modifier class)
        System.out.print( Modifier.isPrivate( modifiersConfig ) ? "private" : "" );
        System.out.print( " " + type );
        System.out.print( " " + name );
        System.out.println();

        if ( type.isPrimitive() ) {
            // primitive type.
            // does not need to be converted.
            // insert in the new class as it is (using Javaassist).
        } else {

            // no primitive type.
            // needs to be converted and tested.
            // insert in the new class after the conversion (using Javaassist).

            // convert rules...
            switch ( type.getSimpleName() ) {

                case "String":
                    // insert in the new class a array of chars.
                    break;

                // cases to test if the field is a wrapper (Integer, Long, etc.).

                // other rules tha you need here...

            }

            // here you need to use recursion...
            // you can use this method, but you will need to create
            // a new parameter, passing the class that is been built
            // to insert new fields in it (relative to the type that is been
            // reflected)

        }
    }

    // return the new class here and outside the method, use the newInstance
    // method to create new instances of this class
    return null;

}