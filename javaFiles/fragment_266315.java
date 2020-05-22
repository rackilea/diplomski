public class Henchman extends AbstractGamePiece {

    // the constructor - not sure what exactly should be passed in here
    // but you get the idea - this constructor doesn't have to have the
    // same "signature" as super's
    public Henchman(String name) {
        super(name, "hm", PLAYER_OUTLAWS);
    }

    // an an implementation of abstract method hasEscaped
    @Override
    public boolean hasEscaped() {
        return false;  // as per the instructions
    }

}