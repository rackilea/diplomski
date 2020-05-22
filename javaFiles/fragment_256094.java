@Test
public void causeAIOException() {
    ListOfNumbers lon = // Create your instance here
    // Create a Spy to be able to mock the method writeNumbers
    ListOfNumbers listOfNumbers = Mockito.spy(lon);
    // This will make any call to writeNumbers throw a IOException
    Mockito.doThrow(IOException.class).when(listOfNumbers)
        .writeNumbers(Matchers.any(PrintWriter.class));
    // Call the method on the spy
    listOfNumbers.writeList();
}