public class ToStringExample {
    String occupation;
    int age;
    String name;

    public ToStringExample(String name) {
        this.name = name;
    }

    public void evaluateValue() {
        if (name.equals("Bob")) {
            occupation = "Farmer";
            age = 31;
        } else if (name.equals("Fred")) {
            occupation = "Programmer";
            age = 45;
        } else {
            occupation = "Undefined";
            age = 22;
        }
    }

    public String toString() {
        return "Name: " + name + "\nOccupation: " + occupation + "\nAge: "
                + age;
    }

    public static void main(String args[]) {
        ToStringExample tse = new ToStringExample("Bob");
        tse.evaluateValue();
        System.out.println(tse);
    }
}