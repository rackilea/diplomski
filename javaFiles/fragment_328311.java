class Actor implements Comparable {

    private int agility;
    private int randomAgility;

    private int getInitiative() {
        //You can change this method as you see fit
        return randomAgility + this.agility;
    }

    public void generateRandomAgility() {
        this.randomAgility = (Math.random() * 100);
    }

    public int compareTo(Object o) {
        Actor other = (Actor)other;
        return this.getInitiative() - other.getInitiative();
    }
}