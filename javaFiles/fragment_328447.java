@Test
    public void testStaticMock() {
        mockStatic(Dummy.class);
        EasyMock.expect(Dummy.testOuter()).andReturn(true);
        EasyMock.expect(Dummy.testInner("bb")).andReturn(true);
        replayAll();
        boolean status = Dummy.testOuter();
        Assert.assertTrue(status);
        status = Dummy.testInner("bb");
        Assert.assertTrue(status);
        verifyAll();
    }