interface ToyBehaviour {

    void execute();
}

public enum Toy {
     DOLL(new DollBehaviour()),
     SOLDIER(new SoldierBehaviour());

     private final ToyBehaviour behaviour;    

     Toy(ToyBehaviour impl) {

        behaviour = impl;
     }

     public void execute() {

        behaviour.execute();
     }
}

class DollBehaviour implements ToyBehaviour {

    public void execute() { 
        System.out.println("I'm a doll."); 
    }
}