public class Animal {
    private int numTeeth;
    private boolean spots;
    private int weight;

    public Animal(int numTeeth, boolean spots, int weight) {
        this.setNumTeeth(numTeeth);
        this.setSpots(spots);
        this.setWeight(weight);
    }

    int getNumTeeth() {
        return numTeeth;
    }

    boolean getSpots() {
        return spots;
    }

    int getWeight() {
        return weight;
    }

    public void setNumTeeth(int numTeeth) {
        this.numTeeth = numTeeth;
    }

    public void setSpots(boolean spots) {
        this.spots = spots;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    static class Lion extends Animal {
        private boolean maine;
        private String region;
        private int type;

        public Lion(boolean maine, String region, int type, int numTeeth, boolean spots, int weight) {
            super(numTeeth, spots, weight);
            this.setMaine(maine);
            this.setRegion(region);
            this.setType(type);
        }

        boolean getMaine() {
            return maine;
        }

        String getRegion() {
            return region;
        }

        int getType() {
            return type;
        }

        public void setMaine(boolean maine) {
            this.maine = maine;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public void setType(int type) {
            this.type = type;
        }

        void showAnimal() {
            System.out.println("The number of teeth is: " + getNumTeeth());
            System.out.println("Does the animal have spots!: " + getSpots());
            System.out.println("The animals weight!: " + getWeight());
            System.out.println("Do the animal have a maine!: " + getMaine());
            System.out.println("The animal is from: " + getRegion());
            System.out.println("The animal is a: " + getType());
        }
    }

    public static void main(String[] args) {
        Lion stats = new Lion(true, "South Africa", 2, 20, false, 150);
    }
}