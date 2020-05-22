abstract class Foo {

    // Override this method
    abstract void doActionInSubclass();

    // You can't override a final method
    // And you don't want subclases to override this one
    final void doAction () {
        // do whatever default-y things you want here
        doActionInSubclass();
    }
}