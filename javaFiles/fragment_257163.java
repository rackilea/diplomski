for(int i = 0; i < args.length; i++) {
    if (args[i].getClass() == Integer.class) {
        classes[i] = int.class;
    } else if (args[i].getClass() == Float.class) {
        classes[i] = float.class;
    } else if (args[i].getClass() == Double.class) {
        classes[i] = double.class;
    } else {
        classes[i] = args[i].getClass();
    }
}