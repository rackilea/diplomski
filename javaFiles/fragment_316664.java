String[] lines = noteText.split("\n");

for (int i = 0; i < lines.length; i++) {
 //The note title. Don't add a bullet point
 if(i == 0) {
    pad.setText(lines[i]);
 } else if (TextUtils.isEmpty(lines[i].trim()) {
    pad.setText(lines[i]);
 } else {
    pad.append("\n" + "\u2022" + "  " + lines[i]);
 }
}