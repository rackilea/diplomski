class Name {

    // Stuff

    @Override
    bool equals(Object other) {
        if(other instanceof Name) {
            Name otherName = (Name)other;
            // Compare this and otherName, return true or false depending
            // on if they're equal
        } else if (other instanceof AbstractA) {
            AbstractA otherAbstractA = (AbstractA)other;
            // Compare this and otherAbstractA, return true or false depending
            // on if they're equal
        } else {
            return false;
        }
    }
}