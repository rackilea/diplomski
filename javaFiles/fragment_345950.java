import java.util.ArrayList;
import java.util.Collections;

public class ComparatorExample {

    static class Person implements Comparable<Person> {
        private String initial;
        private String surName;

        public Person(final String initial, final String surName) {
            this.initial = initial;
            this.surName = surName;
        }

        public String getInitial() {
            return initial;
        }

        public void setInitial(final String initial) {
            this.initial = initial;
        }

        public String getSurName() {
            return surName;
        }

        public void setSurName(final String surName) {
            this.surName = surName;
        }

        @Override
        public int compareTo(final Person o) {
            return surName.compareTo(o.surName);
        }

        @Override
        public String toString() {
            return initial + ' ' + surName;
        }
    }

    public static void main(String[] args) {
        Person a = new Person("A", "John");
        Person b = new Person("B", "Adam");
        Person c = new Person("K", "Henry");
        ArrayList<Person> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

    }
}