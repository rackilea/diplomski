if(on) {
    if (b.equals("0")) return; // Don't really know why you need this one...

    // If the button is ON, add its text label to the list.
    mActiveToggles.add(btn.getText());
} else {
    // If button is OFF, remove its text label from the list.
    mActiveToggles.remove(btn.getText());
}