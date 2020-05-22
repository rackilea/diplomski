mConstraintLayout = (ConstraintLayout) findViewById(R.id.myconstraint_layout)

ConstraintSet set = new ConstraintSet();

// Add constrains - Here R.id.myconstraint_layout is the Id of your constraint layout
set.constrainPercentHeight(R.id.myconstraint_layout, 0.4);
set.constrainPercentWidth(R.id.myconstraint_layout, 0.4);

// Apply the changes - mConstraintLayout is reference to the desired view
set.applyTo(mConstraintLayout);