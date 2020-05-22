@Test
public void testSomething() {
    CapturingAnswer<Void,Date> captureDates = new CapturingAnswer<>(this::getEntityDate)
    Mockito.doAnswer(captureDates).when(persistence).save(Mockito.any(Entity.class));

    service.foo();

    Assert.assertNull(captureDates.getCapturedValues().get(0));
}

private Date getEntityDate(InvocationOnMock invocation) {
    Entity entity = (Entity)invocation.getArguments()[0];
    return entity.getDate();
}