if (date1.toLocalDate().equals(LocalDate.now())) {
    System.out.println("today");                              //< ---
} else if (date1.toLocalDate().isBefore(LocalDate.now())) {
    System.out.println("before now");
} else if (date1.toLocalDate().isAfter(LocalDate.now())) {
    System.out.println("after now");
}