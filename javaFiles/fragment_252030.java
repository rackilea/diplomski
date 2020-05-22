ConstraintLayout layout = findViewById(R.id.constLayout);
    ImageView player = findViewById(R.id.player);
    ImageView target = findViewById(R.id.tile1_3);

    ConstraintSet constraintSet = new ConstraintSet();
    constraintSet.clone(layout);
    constraintSet.connect(player.getId(), ConstraintSet.START, target.getId(), ConstraintSet.START);
    constraintSet.connect(player.getId(), ConstraintSet.END, target.getId(), ConstraintSet.END);
    constraintSet.connect(player.getId(), ConstraintSet.TOP, target.getId(), ConstraintSet.TOP);
    constraintSet.connect(player.getId(), ConstraintSet.BOTTOM, target.getId(), ConstraintSet.BOTTOM);
    constraintSet.applyTo(layout);