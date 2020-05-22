class FindTheRightVisitorVisitor implements CarElementVisitor {
    private CarElementVisitor theVisitor;
    ... getter etc ...
    void visit(Windshield w) {
        if (theVisitors == null) {
            theVisitors = new CarElementWashVisitor();
        }
    }
}