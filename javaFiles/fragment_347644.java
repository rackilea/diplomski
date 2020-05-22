static <T> void helper(Class<T> myClass) {

    Method listMethod = myClass.getDeclaredMethod("list");
    Object returnType = listMethod.invoke(myClass, new Object[]{});
    @SuppressWarnings("unchecked") // [carefully document why this is okay here]
    ArrayList<T> objectList = (ArrayList<T>)returnType;

    ...

    JAXBElement<T> jaxbElement = new JAXBElement<T>(
            new QName("jaxbdemo", "generated"),
            myClass,
            objectList.get(0)
    );

    ...
}