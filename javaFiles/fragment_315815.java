@Test
public void goFigure()
{
  NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
     occurrenceExportResourceUT.getStatus(UUID.randomUUID(), 4);
  }, "Expected getStatus to throw, but it didn't");

  ByteArrayInputStream arrayInputStream = (ByteArrayInputStream) thrown
        .getResponse().getEntity();
  Scanner scanner = new Scanner(arrayInputStream);
  scanner.useDelimiter("\\Z");
  String data = "";
  if (scanner.hasNext())
     data = scanner.next();
  System.out.println(data);
}