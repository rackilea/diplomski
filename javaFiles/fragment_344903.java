class Dog {
    String name;
    Dog(String name) { this.name = name; }
    void bark() { System.out.println(name + " says 'woof!'"); }

    public static void main(String...args) { 
        Dog snoopy = new Dog("snoopy");
        snoopy.bark();
        Dog buddy = new Dog("buddy") {
            @Override void bark() { System.out.println(name + " says 'ruff!'"); }
        };
        buddy.bark();
    }

}