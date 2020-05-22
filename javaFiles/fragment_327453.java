abstract class Parent<T extends ModelType> {
    T model;

    abstract float vertices(T c);

    // To set the model, setter can be created in parent class.
    // Or through constructor of child class.
    void setModel(T modelToSet) {
        this.model = modelToSet;
    }
}

class ChildOne extends Parent<Cuboid> {
    ChildOne(Cuboid c) {
        this.model = c;
    }

    float vertices(Cuboid c) {
        // ... stuff ...
        return 0;
    }
}

class ChildTwo extends Parent<Pyramid> {
    ChildTwo(Pyramid p) {
        this.model = p;
    }

    float vertices(Pyramid p) {
        // ... stuff ...
        return 0;
    }
}