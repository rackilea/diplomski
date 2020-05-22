View rootView = LayoutInflater.from(context).inflate(R.layout.my_cl_custom_view, this, false);
ConstraintSet constraintSet = new ConstraintSet();
this.addView(rootView);
ConstraintLayout.LayoutParams clp = new 
ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 
ViewGroup.LayoutParams.WRAP_CONTENT);
rootView.setLayoutParams(clp);
constraintSet.clone(this);
constraintSet.connect(rootView.getId(), ConstraintSet.LEFT, this.getId(), ConstraintSet.LEFT, 0);
constraintSet.connect(rootView.getId(), ConstraintSet.RIGHT, this.getId(), ConstraintSet.RIGHT, 0);
constraintSet.connect(rootView.getId(), ConstraintSet.TOP, this.getId(), ConstraintSet.TOP, 0);
constraintSet.connect(rootView.getId(), ConstraintSet.BOTTOM, this.getId(), ConstraintSet.BOTTOM, 0);