public int compare(Vehicle o1, Vehicle o2) {

    String makeObj1 = o1.getModel().getMakeName().toLowerCase();
    String makeObj2 = o2.getModel().getMakeName().toLowerCase();

    int indexMake1 = Arrays.asList(makes).indexOf(makeObj1);
    int indexMake2 = Arrays.asList(makes).indexOf(makeObj2);

    if (indexMake1 == -1) indexMake1 = makes.length;
    if (indexMake2 == -1) indexMake2 = makes.length;

    return indexMake1 - indexMake2;
}