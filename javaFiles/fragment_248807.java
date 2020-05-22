final SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
final SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy EEE");
try {
    Date data = inputFormat.parse(eventDate);
    System.out.println(outputFormat.format(data));
} catch (Exception e) {
    System.out.println(e.getMessage());
}