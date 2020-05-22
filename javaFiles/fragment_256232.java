class MyHouse {
    boolean pizzaArrived = false;

    void eatPizza() {
        while (getPizzaArrived() == false) {}
        System.out.println("That was delicious!");
    }

    synchronized boolean getPizzaArrived() {
        return pizzaArrived;
    }

    synchronized void deliverPizza() {
        pizzaArrived = true;
    }
}