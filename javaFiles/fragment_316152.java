class LdapLoggingServiceExctractorTest{
 @Rule 
 public MockitoRule mockito = MockitoJunit.rule();
 @Mock 
 private NamingEnumeration ldapAttributeEnum;
 @Mock 
 private Attribute attr;
 @Before
 public void setup(){
  doReturn(true,false).when(ldapAttributeEnum).hasMore(); // corrected to avoid endless loop...
  doReturn(attr).when(ldapAttributeEnum).next();
  doReturn(1).when(attr).size();
  doReturn(THE_VALID_LOGGER_ENTRY_STRING).when(attr).get(0);
 }
 @Test
 public void extractLogger_singleResultSingleAttribut_addsLoggersCommonNameToList(){
   List<String> securityGroups = new ArrayList<String>();
   LdapLoggingServiceExctractor ldapLoggingServiceExctractor = new LdapLoggingServiceExctractor();

   ldapLoggingServiceExctractor.addLoggerToSecurityGroup(ldapAttributeEnum, securityGroups);

   assertThat(securityGroups.get(0),equalTo(LOGGER_COMMON_NAME));
  }
}