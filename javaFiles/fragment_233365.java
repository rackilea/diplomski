public class RefreshHandlerImplTest
{
 @InjectMocks
 private RefreshHandlerImpl refreshHandlerImpl;

 @BeforeMethod
 public void setUp() throws Exception {
  initMocks(this);
  ReflectionTestUtils.setField(refreshHandlerImpl,RefreshHandlerImpl.class,"readOnlyMode",true,Boolean.class);
 }

 @Test
 public void testRefreshContactsAndBeds_ReturnsZeroContactsWhenCollaboratorsDoes() throws Exception
 {
   ContactBedRefreshResult result = 
   refreshHandlerImpl.refreshContactsAndBeds(unit, true);
   assertThat(result.getContacts()).isEmpty();
 }
}