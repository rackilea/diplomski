Locale saudiArabia = new Locale("ar", "SA");
NumberFormat arabicFormat = NumberFormat.getInstance(saudiArabia);
try {
    Number parsed = arabicFormat.parse("١٥.٨٦");
    System.out.println(parsed);
} catch (ParseException e) {
    e.printStackTrace();
}