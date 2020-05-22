ConstraintLayout cl= (ConstraintLayout) findViewById(R.id.content_main);
            TextProgress tp=new TextProgress(this,null);
            ConstraintLayout.LayoutParams tpParams=new ConstraintLayout.LayoutParams(
ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
            tp.setLayoutParams(tpParams);
            cl.addView(tp);

    ConstraintSet set = new ConstraintSet();

    set.constrainWidth(tp.getId(),ConstraintSet.MATCH_CONSTRAINT);
    set.constrainHeight(tp.getId(),ConstraintSet.WRAP_CONTENT);
    set.connect(tp.getId(), ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
    set.connect(tp.getId(), ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        set.applyTo(cl);