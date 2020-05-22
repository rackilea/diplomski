while (p < borrowedManuals.size()) {
    Manual borrowed = borrowedManuals.get(p); // guessing the name of this class
    if (borrowed.title.equalsIgnoreCase(returnManualTitle)) {
        borrowedManuals.remove(p);
        break;
    }
    p++; // this is mising
}