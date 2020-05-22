@Test
    public void testPartialStaticMock() {
        mockStaticPartial(Dummy.class, "testInner");
        EasyMock.expect(Dummy.testInner("someValue")).andReturn(true);
        replayAll();
        boolean status = Dummy.testOuter();
        verifyAll();
        Assert.assertTrue(status);
    }
}