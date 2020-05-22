class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ArrayListUserDefinedObjectExample {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("David", 31));
        users.add(new User("John", 24));
        users.add(new User("Daniel", 15));


        User u = new User();
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        u.setName(scanner.nextLine());

        for (User user : users){
            if (u.getName().equalsIgnoreCase(user.getName())){
                System.out.println("Your name is " + user.getName() + " and your age is " + user.getAge() +".");
            }
        }
    }
}