if (!myPref.getString("font_style_key", "default").equals("default")) {
    if (myPref.getString("font_style_key", "default").equals("font_1")) {
        textView.setTypeface();
    } else if (myPref.getString("font_style_key", "default").equals("font_2")) {
        textView.setTypeface();
    }
}