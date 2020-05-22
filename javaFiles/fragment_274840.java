try {
    MyClass dict = mock(MyClass.class);
    Object obj1 = new Object();

    when(dict.copy(anyObject())).thenThrow(ClassNotFoundException.class);
    dict.copy(obj1);
} catch (ClassNotFoundException ex) {
    ex.printStackTrace();
}