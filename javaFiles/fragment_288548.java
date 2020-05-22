class FruitProducer {
    public static Fruit[] produce() {
        Fruit[] list = new Fruit[] { new Orange(), new Banana() };
        return list;
    }
}

class UnknownClient {
    public static void main(String args[]) {
        Fruit[] listOfFruit = FruitProducer.produce();
        foreach (Fruit f : listOfFruit) {
            f.callingName(); 
        }
    }
}