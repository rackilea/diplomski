@Test
public void testDate() {
    String date = "2019-08-30 12:00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime localTimeDate = LocalDateTime.parse(date, formatter);
    assertTrue(localTimeDate.toString().equals(date));
}

@Test
public void testDateWithoutTime() {
    String date = "2019-08-30";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(date, formatter);
    assertTrue(localDate.toString().equals(date));
}