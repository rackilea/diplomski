public abstract class A {
    public A() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.getType() != String.class) {
                throw new RuntimeException("only String type of fields are allowed");
            }
        }   
    }
}