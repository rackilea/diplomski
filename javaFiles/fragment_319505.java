public static void main(String[] args) {

    String[] names = {Max, Bella, Jack};
    Dog[] dog = new Dog[names.length]; 
    for (int i = 0; i < names.length; i++) {
        dog[i] = new Dog();
        dog[i].name = names[i];
        System.out.println(dog[i].name);
    }
}