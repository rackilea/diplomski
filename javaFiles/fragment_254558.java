for (Annotation a : anno[0]) {
    if (a instanceof AnnoTestArg) {
        AnnoTestArg arg = (AnnoTestArg) a;
        System.out.println(arg.value());
    }
}