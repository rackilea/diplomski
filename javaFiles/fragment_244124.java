String datatype = "java.lang.Integer";
Object integer = 42;
Object castedInteger = null;

try {
    Class intClass = Class.forName(datatype);
    castedInteger = intClass.cast(integer);

    System.out.println(integer.getClass() + " " + castedInteger.getClass());
} catch (ClassNotFoundException e) {
        e.printStackTrace();
}