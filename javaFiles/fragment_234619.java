@Before
public void setUp() {
    contactService = EasyMock.createMock(ContactServiceImpl.class);     
    holderService.setContactServiceImpl(contactService);
    EasyMock.expect(contactService.create(EasyMock.anyObject(Contact.class))).andReturn(new Contact()).anyTimes();
}