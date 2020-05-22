public class ApplicationTest {

    @Test
    public void test()
    {
        Application.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=blahblahblah",
                // Override any other environment properties according to your needs
        });
    }
}