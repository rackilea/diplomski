public abstract class Piece {
    // put in fields that every piece has, e.g. x and y co-ordinate here

    // array of powers
    protected ArrayList<Power> powers=new ArrayList<Power>();

    // method to add new powers to the piece
    public void addPower(Power power) {
        powers.add(power);
    }

    // power method - optionally overriden by specififc pieces
    public void applyPowers() {
        for (Power power:powers) {
            power.methodToActivatePower();
        }
    }

    // abstract char method
    public abstract char getChar();

}