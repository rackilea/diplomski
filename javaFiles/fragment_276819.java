interface AnimalVisitor {
    void visit(Lion l);
    void visit(Deer d);
}

class ActionVisitor implements AnimalVisitor {

    public void visit(Deer d) {
        d.runAway();
    }

    public void visit(Lion l) {
        l.roar();
    }
}