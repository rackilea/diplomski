if (position == 0) {
    name.setTextColor(name.getHintTextColors());
    subtitle.setVisibility(GONE)
}
else {
    name.setTextColor(name.regularColor());
    subtitle.setVisibility(VISIBLE)
}