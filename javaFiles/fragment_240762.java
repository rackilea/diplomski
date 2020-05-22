String desc = "(ILjava/lang/String;)[I";

    // params
    for(Type type : Type.getArgumentTypes(desc)){
        System.out.println(type.getClassName());
    }

    //return type
    System.out.println(Type.getReturnType(desc).getClassName());