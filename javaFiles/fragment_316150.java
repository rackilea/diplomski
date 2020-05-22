class LdapLoggingServiceExctractorTest{
 @Rule 
 public MockitoRule mockito = MockitoJunit.rule()
 @Mock 
 private DirContext dirContext;
 @Mock 
 NamingEnumeration<SearchResult> results;
 @Mock 
 private SearchResult loggerSearchResult;
 @Mock 
 private Attributes ldapAttributes; // same name but different object!!
 @Mock 
 private NamingEnumeration ldapAttributeEnum;
 @Mock 
 private Attribute attr;

 @Before
 public void setup(){
  doReturn(results).when(dirContext).search(any(Name.class),anyString(),any(SearchControls));
  doReturn(loggerSearchResult).when(results).nextElement();
  doReturn(ldapAttributes).when(loggerSearchResult).getAttributes();
  doReturn(ldapAttributeEnum).when(loggerSearchResult).getAll();
  doReturn(true).when(ldapAttributeEnum).hasMore();
  doReturn(attr).when(ldapAttributeEnum).next();
  doReturn(1).when(attr).size();
  doReturn(THE_VALID_LOGGER_ENTRY_STRING).when(attr).get(0);
 }


 @Test
 public void extractLogger_singleResultSingleAttribut_addsLoggersCommonNameToList(){
   LdapLoggingServiceExctractor ldapLoggingServiceExctractor = new LdapLoggingServiceExctractor();

   ldapLoggingServiceExctractor.extractLogger(dirContext);

   assertThat(ldapLoggingServiceExctractor.getSecurityGroups().get(0),equalTo(LOGGER_COMMON_NAME));
  }
}