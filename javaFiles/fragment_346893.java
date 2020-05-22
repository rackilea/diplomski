class MyAssignmentListVisitor extends ASTVisitor {
    @Override
    public boolean visit(Assignment assignment) {
        FieldAccessLineralizationVisitor leftHandSideVisitor = new FieldAccessLineralizationVisitor();
        assignment.getLeftHandSide().accept(leftHandSideVisitor);
        LinearFieldAccess leftHandSidePath = leftHandSideVisitor.asLinearFieldAccess();

        FieldAccessLineralizationVisitor rightHandSideVisitor = new FieldAccessLineralizationVisitor();
        assignment.getRightHandSide().accept(rightHandSideVisitor);
        LinearFieldAccess rightHandSidePath = rightHandSideVisitor.asLinearFieldAccess();

        processAssigment(leftHandSidePath, rightHandSidePath);

        return true;
    }
}

class FieldAccessLineralizationVisitor extends ASTVisitor {

    List<?> significantFieldAccessParts = [...];

    // ... various visit method expecting concrete subtypes of Expression ...

    @Override
    public boolean visit(Assignment assignment) {
        // Found an assignment inside an assignment; ignore its
        // left hand side, as it does not affect the "path" for 
        // the assignment currently being investigated

        assignment.getRightHandSide().accept(this);

        return false;
    }
}