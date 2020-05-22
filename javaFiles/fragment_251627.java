class Cat
{
    public static void main(String[] args)
    {
        // 1)
        Cat cat = new Cat();
        // 2)
        Animal anotherCat = new Cat(); // Perfectly possible.
    }
}

class Animal {}

class Cat extends Animal {}