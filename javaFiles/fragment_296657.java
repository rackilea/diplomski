class Parent {
    public final void method() {
    }
}
class Child extends Parent {
    @Override                   // <== Won't compile, you simply can't override
    public void method() {      // <== final methods at all (even if you added
                                // <== "final" to the declaration)
    }
}