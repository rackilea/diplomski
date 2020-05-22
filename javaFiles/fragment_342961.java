class Animal {
}

class Bear extends Animal {
    public void growl() { ... }
}

class Cat extends Animal {
    public void meow() { ... }
}

Animal a1 = new Bear();
Animal a2 = new Cat();

// Doesn't work, because not every Animal is a Bear, and not all
// animals can growl.
a1.growl();

// You wouldn't expect this to work, because a2 is a Cat.
a2.growl();