class Parent {
    @Override public String toString() {
        return "Parent";
    }
}

class Child extends Parent {
    @Override public String toString() {
        return "Child";
    }

    public void callToString() {
        System.out.println(toString()); // "Child"
        System.out.println(super.toString()); // "Parent"
    }
}