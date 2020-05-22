ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.mainConstraint);
ConstraintSet set = new ConstraintSet();

ImageView view = new ImageView(this);
view.setId(View.generateViewId());
layout.addView(view,0);
set.clone(layout);
set.connect(view.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP, 60);
set.applyTo(layout);