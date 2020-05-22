class Foo {
    Foo parent = null;
    Color color;

    Foo(Foo parent) {
        this.parent = parent;
    }

    Color getColor() {
        //If there is no parent we have to return color regardless.
        if (parent == null) {
            return color;
        }

        // If there is a parent we can choose which to return.
        return color == null ? parent.getColor() : color;
    }

    void setColor(Color color) {
        this.color = color;
    }
}