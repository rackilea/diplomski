boolean isEnabled = false;

for (int i = 0; i < product.size(); i++) {
    if (product.get(i).get("check_box_enable").equalsIgnoreCase("false")) {
         isEnabled = true;
         break;
    }
}

check_to_answer.setEnabled(isEnabled);

if (isEnabled) {
    check_to_answer.setBackgroundColor(getResources().getColor(R.color.orange_color));
} else {
    // ...
}