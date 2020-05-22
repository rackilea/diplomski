@Test
public void testGetDiscountRate() {
    System.out.println("getDiscountRate");
    BusinessOrganisationDetails instance = new BusinessOrganisationDetails();
    instance.setCompanyDiscount(50);
    int expResult = 50;
    int result = instance.getDiscountRate();
    assertEquals(expResult, result);
}