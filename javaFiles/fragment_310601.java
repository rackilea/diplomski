interface IHasName {
    String getName();
}

class Person implements IHasName {
    private final String name;
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class GenericUtility {
    public static <T extends IHasName> String addNames(T first, T second) {
        return first.getName() + ", " + second.getName();
    }
}

class Main {
    public static void main(String[] args) {
        Person first = new Person("Peter");
        IHasName second = new IHasName() {
            @Override
            public String getName() {
                return "John";
            }
        };
        String result = GenericUtility.addNames(first, second);
        System.out.println(result);
    }

}