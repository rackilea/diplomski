public enum Toy {
     // enum values
     DOLL(new DollBehaviour()),
     SOLDIER(new SoldierBehaviour());

     private final ToyBehaviour behaviour;    

     Toy(ToyBehaviour impl) {

        behaviour = impl;
     }

     public void execute() {

        behaviour.execute();
     }

    // behaviour interface
    interface ToyBehaviour {

        void execute();
    }

    // behaviour implementation (sub)classes
    static class DollBehaviour implements ToyBehaviour {

        public void execute() { 
            System.out.println("I'm a doll."); 
        }
    }

    // etc ...
}