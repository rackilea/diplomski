@Test
public void testIfIdNull() {
    WorkerId workerId = null;
    Integer result = workerIdConverter.convertToDatabaseColumn(workerId);
    assertThat(result).isEqualTo(null);
}