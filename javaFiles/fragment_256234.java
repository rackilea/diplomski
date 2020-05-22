class MyHouse {
    boolean pizzaArrived = false;

    void eatPizza() {
        synchronized (this) {
            while (!pizzaArrived) {
                try {
                    this.wait();
                } catch (InterruptedException e) {}
            }
        }

        System.out.println("That was delicious!");
    }

    void deliverPizza() {
        synchronized (this) {
            pizzaArrived = true;
            this.notifyAll();
        }
    }
}