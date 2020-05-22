@Test
public void getMonthAndCount() {
    List<MonthAndCount> monthAndCount = repo.getMonthAndCount(2017);
    assertThat(monthAndCount).hasSize(4);
    monthAndCount.forEach(System.out::println);
}