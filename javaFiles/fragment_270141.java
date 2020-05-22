public class Solution {
    public static void main(String[] args) {
        Animal animal1 = new Cow();
        Animal animal2 = new Whale();

        ArrayList<Animal> myAnimals = new ArrayList<Animal>();
        myAnimals.add(animal1);
        myAnimals.add(animal2);
        //show all my animals
        for (Animal animal : arrayList) {
            System.out.println(animal.getName());

        }


    }


    public static class Animal {
        public String getName() {
            return "Im general animal";
        }
    }

    public static class Cow extends Animal {
        public String getName() {
            return "Im cow";
        }
    }

    public static class Whale extends Animal {
        public String getName() {
            return "Im whale";
        }
    }
}