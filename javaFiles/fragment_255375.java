@RunWith(SpringJUnit4ClassRunner.class)
@ProfileValueSourceConfiguration(ProfileTest.ProfileProfileValueSource.class)
@SpringApplicationConfiguration(classes = ProfileTest.class)
//won't work since not added to system properties!
//@ActiveProfiles("integration")
public class ProfileTest
{

@Test
public void contextLoads()
{
}

@IfProfileValue( name = "integration", value = "true")
@Test
public void runInIntegration()
{
    throw new RuntimeException("in integration");
}

@Test
public void runDemo()
{
    System.out.println("DEMO, running always");
}

public static class ProfileProfileValueSource implements ProfileValueSource
{
    @Override
    public String get(String string)
    {
        final String systemProfiles = System.getProperty("spring.profiles.active", System.getProperty("SPRING_PROFILES_ACTIVE", ""));

        final String[] profiles = systemProfiles.split(",");

        return Arrays.asList(profiles).contains(string) ? "true" : null;
    }

}
}