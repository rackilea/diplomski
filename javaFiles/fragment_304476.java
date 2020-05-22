class WantToBeUsed {
    public void methodToBeUsed(String data) {
        //fancy implementation
    }
}
class CannotDoThisAlone {
    public void cannotDoItAlone(String data) {
        WantToBeUsed wantToBeUsed = new WantToBeUsed();
        wantToBeUsed.methodToBeUsed(data);
    }
}