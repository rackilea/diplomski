try {
    Assert.assertTrue(hotel.getAmenitiesList().size() < 0, "Hotel Amenities Available!");

} catch (Throwable e) {
    e.printStackTrace();
    logger.error("FAILED: testRoomAmenities ", e);
    Assert.fail();