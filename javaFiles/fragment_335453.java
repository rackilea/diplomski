public class ParkingLotTest {

    //...

    @Test
    public void shouldGetLicensesWithAParticularColour() throws Exception {
        List<Car> expected = new ArrayList<Car>();
        expected.add(...);

        assertEquals(expected, parkingLot.licenseWithAParticularColour("White"));
    }

}