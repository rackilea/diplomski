final ConstraintLayout content = findViewById(R.id.content_layout);

final ConstraintLayout expandableView = findViewById(R.id.expandableView);
final Button arrowBtn = findViewById(R.id.arrowBtn);
arrowBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (expandableView.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(content, new AutoTransition());
                expandableView.setVisibility(View.VISIBLE);
                arrowBtn.setBackgroundResource(R.drawable.down_arrow);
            } else {
                TransitionManager.beginDelayedTransition(content, new AutoTransition());
                expandableView.setVisibility(View.GONE);
                arrowBtn.setBackgroundResource(R.drawable.android_icon);
            }
        }
    });

final ConstraintLayout expandableView2 = findViewById(R.id.expandableView2);
final Button arrowBtn2 = findViewById(R.id.arrowBtn2);
arrowBtn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (expandableView2.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(content, new AutoTransition());
                expandableView2.setVisibility(View.VISIBLE);
                arrowBtn2.setBackgroundResource(R.drawable.down_arrow);
            } else {
                TransitionManager.beginDelayedTransition(content, new AutoTransition());
                expandableView2.setVisibility(View.GONE);
                arrowBtn2.setBackgroundResource(R.drawable.android_icon);
            }
        }
    });