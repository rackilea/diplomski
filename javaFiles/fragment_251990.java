@Test
public void shouldBeZeroSinceMinutesCantBeNegative() {
    int initialMinutes = EmployeeHours.STEP - 1;
    EmployeeHours employeeHours = new EmployeeHours(null, 1, initialMinutes);
    employeeHours.decreaseMinutes();
    assertThat(employeeHours.getMinutes(), is(0));
}