@Test
public void shouldNotGetLicensesWithANullColour() throws Exception {
    ...
    assertEquals(expected, parkingLot.licenseWithAParticularColour(null));
}

@Test
public void shouldNotGetLicensesWithAnUnknownColour() throws Exception {
    ...
    assertEquals(expected, parkingLot.licenseWithAParticularColour("unknown"));
}