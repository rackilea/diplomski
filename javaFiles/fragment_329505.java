MotionLayout myMotionLayout = findViewById(R.id.myMotionLayout);
Button button = findViewById(R.id.button);

button.setOnClickListener( v -> {
    if(myMotionLayout.getCurrentState() == R.id.start_state) {
        myMotionLayout.transitionToEnd()
    } else {
        myMotionLayout.transitionToStart()
    }
  }
);