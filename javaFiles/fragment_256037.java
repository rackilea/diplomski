@Test
    public void autoMoveTest(){
        FileOperations fo = new  FileOperations("");
        FileOperations spyFo = spy(fo);

        List<byte[]> dummyPatterns = new ArrayList<byte[]>();//specify stub value
        dummyPatterns.add("amit".getBytes());

        when(spyFo.getListofPatterns()).thenReturn(dummyPatterns);
        when(spyFo.seekInHeader(anyString().getBytes())).thenReturn(true);//stubbing a method

        assertTrue(spyFo.autoMove());
    }