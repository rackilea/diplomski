@BeforeTransaction
    public void setUp() {
        System.out.println("setUp");
        advertisement = advertisementFactory.createAdvertisement(OWNER_OF_ADVERTISEMENT_EMAIL);
        impersonator = memberFactory.createMember(IMPERSONATOR_EMAIL, Role.ROLE_BASIC_CHILDCAREWORKER);
        when(geolocationServiceMock.retrieveAddressFromReference("valid-reference")).thenReturn(new Address());
    }

    @AfterTransaction
    public void tearDown() {
        System.out.println("tearDown");
        advertisementFactory.deleteAdvertisement(advertisement);
        memberFactory.deleteMember(impersonator);
    }