LinearLayout layout = findViewById(R.id.main);

Ball ball = new Ball(this);
ball.setLayoutParams(new LinearLayout.LayoutParams(
    LinearLayout.LayoutParams.WRAP_CONTENT,
    LinearLayout.LayoutParams.WRAP_CONTENT));

layout.addView(ball);