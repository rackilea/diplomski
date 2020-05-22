public static void main(String[] args) {
     LocalDate futureDate = LocalDate.now().plusMonths(2);
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
     String dateStr = futureDate.format(formatter);
     System.out.println(dateStr);
}