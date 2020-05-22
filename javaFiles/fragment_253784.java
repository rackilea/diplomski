LinearLayout layout = (LinearLayout) findViewById(R.id.linearTest);
layout.setOrientation(LinearLayout.VERTICAL);

for (int i = 0; i <= 5; i++) {
        Button btn= new Button(this, null,R.style.button_learn);
        btn.setText(grammarBank.getLessonTitle(i));
        layout.addView(btn);
    }