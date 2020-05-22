if (this instanceof Subclass1) {
    anotherClass.exampleMethod((Subclass1)this);
} else if (this instanceof Subclass2) {
    anotherClass.exampleMethod((Subclass2)this);
}
...