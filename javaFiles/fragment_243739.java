public void testDatapathResolution() throws Exception{
    String[] path = datapathToFeature.split("\\.");
    assertEquals("Owner", path[0]);
    assertEquals("Name", path[1]);
    DatapathObject result = resolveDatapath(datapathToFeature, car);
    result.getField().setAccessible(true);
    Object value = result.getField().get(result.getParent());

    assertEquals(car.getOwner().getName(), value.toString());
}