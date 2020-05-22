@Override
public String toString() {
    return ("The Secret Word you entered: " + this.getWord()
            + ".\n The max # of tries (Must be under 7): "
            + this.getTriesLimit());
}