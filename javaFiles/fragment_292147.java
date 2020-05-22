private void performDial(String numberString) {
if (!numberString.equals("")) {
   Uri number = Uri.parse("tel:" + numberString);
   Intent dial = new Intent(Intent.ACTION_CALL, number);
   startActivity(dial);
}