class Creature implements Bagable {
    public String getType() {
        return "Creature";
    }
    // Normal Creature Class methods...
}
class Building implements Bagable {
    public String getType() {
        return "Buidling";
    }
    // Normal Building Class methods...
}
class Magic implements Bagable {
    public String getType() {
        return "Magic";
    }
    // Normal Magic Class methods...
}

public static void main(String args[]) {
    ArrayList<Bagable> bag = new ArrayList<Bagable>();

    bag.add(new Creature());
    bag.add(new Building());
    bag.add(new Magic());

    for (int i = 0; i < bag.size(); i++ ) {
        System.out.println(bag.get(i).getType());
    }
}