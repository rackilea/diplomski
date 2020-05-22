dataTable.visitTree(VisitContext.createVisitContext(), new VisitCallback() {
    @Override
    public VisitResult visit(VisitContext context, UIComponent component) {
        // Check if component is instance of <p:calendar> and collect its value by its ID.

        return VisitResult.ACCEPT;
    }
});