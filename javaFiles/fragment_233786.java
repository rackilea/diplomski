@Test(expected=RuntimeException.class)
    public void testdecrpyMcpDataExceptions() throws Exception {
        Crypto mockCrypto = mock(Crypto.class);

        doThrow(new RuntimeException()).when(mockCrypto).closeSession();
        mockCrypto.closeSession();

    }