@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PersonRepository.class})
@TestPropertySource(properties = 
{"spring.ldap.embedded.ldif=test_schema.ldif", "spring.ldap.embedded.base-dn=dc=test,dc=com"})
@EnableAutoConfiguration
public class Tests {
    //...
}