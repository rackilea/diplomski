int newsLetters = 3;
final Calendar cal = Calendar.getInstance(Locale.US);
for (int i = 0; i < newsLetters; i++) {
  cal.add(Calendar.MONTH, -3);
  int quarter = (cal.get(Calendar.MONTH) / 3) + 1;
  System.out.println("Newsletter Q" + quarter + " " + cal.get(Calendar.YEAR));
}