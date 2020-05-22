@RunWith(SpringRunner.class)
 @SpringBootTest
 public class EmailValidatorTest {

@MockBean
private configurationProvider1 configurationReader;

@Autowire
private DefaultEmailValidator validator

@Test
public void testGetConfigValue(){
    String a = validator.getConfigValue(configurationReader,"mail.subject.max.length");
    System.out.println(a);
}