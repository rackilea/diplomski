class Mammal extends Animal{
    void methodA(){
        super.methodA();// --> calling Animal's methodA()
    }
    void methodAB(){
        System.out.println("Two child class Dog and Cat I have");
    }
}