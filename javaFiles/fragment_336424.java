boolean hasAce = false;
for (int i = 0; i < hand.length; i++) {
    if (hand[i].getFace().equals("Ace"))
        hasAce = true;
}

// ... Current code ....

if (!isStraight && hasAce) {

    isStraight = true;
    for (int i = 9; i < 13; i++) {
        boolean found = false;
        for (int j = 0; j < hand.length; j++) {
            if (hand[j].getFace().equals(faces[i])) {
                found = true;
                str++;
            }
        }
        if (!found) {
            str = 0;
            isStraight = false;
            break;
        }
    }
}
return isStraight;