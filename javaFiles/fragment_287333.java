try {
    outerMock.somefunction();
    fail("was expecting an exception..");
} catch(Exception exception) {
    // ignore
}

verify(bMock).another();
verify(cMock, never()).cleanup()