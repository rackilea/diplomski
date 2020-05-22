@Test
public void testIfIdNull() {
    WorkerId workerId = null;
    Integer result = workerIdConverter.convertToDatabaseColumn(workerId);
    Assert.assertNull(result);
}