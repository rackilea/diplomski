ViewGroup layout = findViewById(R.id.your_layout);
for (int i = 0; i < layout.getChildCount(); i++) {
    View child = layout.getChildAt(i);
    if (child instanceof Button) {
        // Operate with button
    }
}