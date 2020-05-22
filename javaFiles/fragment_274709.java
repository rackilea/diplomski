public class One {
    public static List<String> names = new ArrayList<>();
}

public class Two {
    public void addName(String name) {
        One.names.add(name);
    }
}

public class Three {
    public void printTheNames() {
        System.out.println(One.names);
    }
}