@Test
public void exampleTest(@Mocked SpecializedDao mockDao) {
    ObjectX objectResult = new ObjectX();

    new Expectations() {{
        mockDao.currentObjectXByTimestamp(anyX, anyY, anyZ); result = objectResult;
    }};


    // Call the SUT.
}