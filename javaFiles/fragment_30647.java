public class Dog {

    private String name;
    private int age;

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

    public static Dog[] removeByName(Dog[] list, String name) {
        int counter = 0;
        Dog[] result = new Dog[3];
        for (int i = 0; i < list.length; i++) {
            if (!list[i].getName().equals(name)) {
                result[counter] = list[i];
                counter++;
            }
        }
        return result;
    }

}