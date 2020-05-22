for(TextView tv : textViewsList) {
  tv.setId(generateViewId()); // Views must have IDs in order to add them to chain later.
  constraintLayout.addView(tv);
}

ConstraintSet constraintSet = new ConstraintSet();
constraintSet.clone(rootView);

View previousItem = null;
for(TextView tv : textViewsList) {
  boolean lastItem =textViewsList.indexOf(tv) == textViewsList.size() - 1;
  if(previousItem == null) {
    constraintSet.connect(tv.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
  } else {
    constraintSet.connect(tv.getId(), ConstraintSet.TOP, previousItem.getId(), ConstraintSet.BOTTOM);
    if(lastItem) {
      constraintSet.connect(tv.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
    }
  }
  previousItem = tv;
}