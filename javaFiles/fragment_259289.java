public class Solution {

    // Create interface
    interface Computable {
        void compute();
    }

    // SlotReel implement Computable interface
    static public class SlotReel implements Computable {

        String name;

        public SlotReel(String name) {
            this.name = name;
        }

        // Implement compute method
        @Override
        public void compute() {
            // call after SlootReel is added to stage
            // Just an example
            System.out.println("Hello " + name);
        }

    }

    static public class Stage {

        List<Computable> list = new ArrayList<>();

        public void addActor(Computable slot) {
            list.add(slot);
            // call compute method
            slot.compute();
        }
    }

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.addActor(new SlotReel("A"));
        stage.addActor(new SlotReel("B"));
        stage.addActor(new SlotReel("C"));
        stage.addActor(new SlotReel("D"));
    }
}