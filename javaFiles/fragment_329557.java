@Test
public void create() throws Exception {

   doNothing().when(filesControllerSpy)
     .validateAdding(any(String.class), any(Map.class), any(File.class));
   ...