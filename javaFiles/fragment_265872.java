class TrafficLight {
    enum State {
        RED, YELLOW, GREEN
    };

    State state = State.GREEN;

    public void iterate() throws InterruptedException {
        switch (this.state) {
        case RED:
            System.out.println("RED");
            Thread.sleep(1000);
            this.state = State.GREEN;
            break;

        case GREEN:
            System.out.println("GREEN");
            Thread.sleep(1000);
            this.state = State.YELLOW;
            break;

        case YELLOW:
            System.out.println("YELLOW");
            Thread.sleep(1000);
            this.state = State.RED;
            break;
        }

    }