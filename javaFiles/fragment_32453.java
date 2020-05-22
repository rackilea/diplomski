abstract class AnimatedAbstractWalker extends Animate {

    // class gets concrete methods from Animate

    // and any abstract walk methods you want to add
    // (this replaces the Walk interface)
}

class Cat extends AnimatedAbstractWalker {
    // inherits standard animation implementation
    // you must implement walking like a cat
}

class Dog extends AnimatedAbstractWalker {
    // inherits standard animation implementation
    // you must implement walking like a dog
}