class Animal{
    private Animal() {
    }

    public void speak(){
        System.out.println("I am an Animal");
    }

    static class Tiger extends Animal {
        public void speak() {
            System.out.println("I am an Animal and Tiger");
        }
    }

    static class Horse extends Animal {
        public void speak() {
            System.out.println("I am an Animal and Horse");
        }
    }
}