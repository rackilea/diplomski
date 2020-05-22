private static class ClassWithField {
    public int length;
}

ClassWithField obj = new ClassWithField();
int length = obj.length;  // .length is normal field access
int lengthViaRelection = (int) ClassWithField.class.getDeclaredField("length").get(obj);