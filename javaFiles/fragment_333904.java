protected TableLayout.Constraint createCellConstraint(Object value, int row, int column) {
   TableLayout.Constraint constraint = ((TableLayout) this.getLayout()).createConstraint();
   constraint.setVerticalAlign(CENTER);
   addComponent(constraint);
   constraint.setWidthPercentage(100 / getModel().getColumnCount());
   ...
 }