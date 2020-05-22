for (int x = 0; i < string.length; x++) {
        Button word = new Button(context);
        word.setText(string[x]+"");
        LinearLayout.LayoutParams left_on = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,1);
        word.setLayoutParams(left_on);
        myLinearLayout.addView(word);
    }