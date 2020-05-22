StringBuilder allLabels = new StringBuilder();
for(String s : mActiveToggles) {
    if(allLabels.length() > 0) {
        allLabels.append(" "); // some divider between the different texts
    }
    allLabels.append(s);
}
display.setText(allLabels.toString());