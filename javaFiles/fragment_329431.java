public final class User {
    private final Department department;
    private final String name;

    public User(Department department, String name) {
        this.department = department;
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }
}

public final class Department {
    private final List<User> users;
    private final String name;

    ///Reversed argument list to avoid collision after erasure
    public Department(String name, List<String> users) {
        this.users = Collections.unmodifiableList(users.stream()
                .map((s) -> new User(this,s)).collect(Collectors.toList()));
        this.name = name;
    }

    public Department(List<User> users, String name) {
        this.users = Collections.unmodifiableList(users);
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }
}