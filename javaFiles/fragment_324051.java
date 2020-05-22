ColumnConstraints leftFiller = new ColumnConstraints();
leftFiller.setHgrow(Priority.ALWAYS); // Fills the space left on the left side
ColumnConstraints rightFiller = new ColumnConstraints();
rightFiller.setHgrow(Priority.ALWAYS); // Fills the space left on the right side
topGrid.getColumnConstraints().addAll(leftFiller, new ColumnConstraints(), 
    new ColumnConstraints(), rightFiller);

topGrid.add(sloganLbl, 1, 0);
topGrid.add(signUpBtn, 2, 0);