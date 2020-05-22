abstract class Someclass {
    final void clickedOnItem1(){
        if(this.getConcreteOption()) {
             //do if concreteOption
        }

        this.performClickOnItem1Action();
    }

    void performClickOnItem1Action() {

    }

    abstract boolean getConcreteOption();
}