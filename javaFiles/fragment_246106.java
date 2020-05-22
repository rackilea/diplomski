public boolean choiceOfItem(){
    if (bread)
        this.Choice("bread");
    else if (meat)
        this.Choice("meat");
    else if (lettuce)
        this.Choice("lettuce");
    else if (tomato)
        this.Choice("tomato");
    else if (carrot)
        this.Choice("carrot");
    else return false;
    return true;
}

@Override
public boolean choiceOfItem() {
    if (super.choiceOfItem())
        return true;
    if (ryeBread) {
        this.Choice("ryeBread");
        return true;
    }
    return false;
}