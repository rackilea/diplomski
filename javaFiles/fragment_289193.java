ConstraintSet constraintSet = new ConstraintSet();
constraintSet.clone(layout); // root layout

// If you want to align parent to the layout left
constraintSet.connect(textView.getId(), ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT);

// If you want to align to the left of one more textview - second text view
constraintSet.connect(textView.getId(), ConstraintSet.RIGHT, textView1.getId(), ConstraintSet.LEFT);

/*______________________________
|      Text1     Text2       |
|                            |*/
constraintSet.applyTo(layout);