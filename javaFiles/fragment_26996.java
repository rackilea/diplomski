for (Lesson lesson : lessons) {

    Button button = new Button(LessonsActivity.this);
    button.setText(lesson.getName());
    button.setId(lesson.getNumber());
    button.setLayoutParams(params);
    button.setTextSize(20);
    /*button.setBackground(this.getResources().getDrawable(R.drawable.buttons));*/
    button.setOnClickListener(new View.OnClickListener() {
    @SuppressLint("ShowToast")
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LessonsActivity.this, WelcomeActivity.class);
            startActivity(intent);
            }
        });

        row.addView(button);
    }
    layout.addView(row);
}