import java.util.Arrays;

public class ArrayFiller {
    public static void main(String[] args) {
        // your first version:
        Person[][] yourFirstVersion = new Person[2][2];
        for (Person[] array : yourFirstVersion) {
            Arrays.fill(array, new Person("Mike"));
        }
        System.out.println(Arrays.deepToString(yourFirstVersion));
        yourFirstVersion[0][1].setName("Paul");
        System.out.println(Arrays.deepToString(yourFirstVersion));
        System.out.println("-----");
        // equivalent: my version:
        Person[][] myVersion = new Person[2][2];
        for (Person[] array : myVersion) {
            Person person = new Person("John");
            Arrays.fill(array, person);
        }
        System.out.println(Arrays.deepToString(myVersion));
        myVersion[0][1].setName("Thomas");
        System.out.println(Arrays.deepToString(myVersion));
        System.out.println("-----");
        // your second version
        Person[][] yourSecondVersion = new Person[2][2];
        for (int i = 0; i < yourSecondVersion.length; i++) {
            for (int j = 0; j < yourSecondVersion[i].length; j++) {
                yourSecondVersion[i][j] = new Person("Max");
            }
        }
        System.out.println(Arrays.deepToString(yourSecondVersion));
        yourSecondVersion[0][1].setName("Chris");
        System.out.println(Arrays.deepToString(yourSecondVersion));
    }

    private static class Person {
        private String name;
        public Person(String name) {
            System.out.println("Constructor called for " + name);
            this.name = name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }
}