class House implements HouseAcceptor {
    HouseAcceptor kitchen;
    HouseAcceptor livingRoom;

    void accept(HouseVisitor visitor) {
        visitor.visit(this);
        kitchen.accept(visitor);
        livingRoom.accept(visitor);
    }
}

class Kitchen implements HouseAcceptor {
    void accept(HouseVisitor visitor) {
        visitor.visit(this);
    }
}

class LivingRoom implements HouseAcceptor {
    void accept(HouseVisitor visitor) {
         visitor.visit(this);
    }
}

class SpeakingHouseVisitor implements HouseVisitor {
    void visit(HouseAcceptor acceptor) {
        System.out.println("Inside a HouseAcceptor");
    }

    void visit(House acceptor) {
        System.out.println("Inside a House");
    }

    void visit(Kitchen acceptor) {
        System.out.println("Inside a Kitchen");
    }

    void visit(LivingRoom acceptor) {
        System.out.println("Inside a LivingRoom");
    }
}

...
HouseAcceptor acceptor = new House();
HouseVisitor visitor = new SpeakingHouseVisitor();

...
// Doing it your way
visitor.visit(acceptor);
// Output: Inside a HouseAcceptor

// Doing it the right way
acceptor.accept(visitor);
// Output:
// Inside a House
// Inside a Kitchen
// Inside a LivingRoom