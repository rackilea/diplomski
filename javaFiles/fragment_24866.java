class A extends Object {
    public boolean isHashCodeOverridden() throws Exception {
        return !this.getClass()
            .getMethod("hashCode")
            .getDeclaringClass()
            .equals(Object.class);
    }
}

class B extends A {
    public int hashCode() { return 0; }
}

class C extends B {}

class D extends C {}