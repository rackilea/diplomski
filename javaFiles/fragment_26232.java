if ((event.getSource() == btnred) && defaultLetter > 'A') {
    defaultLetter--;
    text.setText(String.valueOf(defaultLetter));
}
if ((event.getSource() == btngreen) && defaultLetter < 'Z') {
     defaultLetter++;
     text.setText(String.valueOf(defaultLetter));
}