public class TheVersionClass
{
    ..

    public TheVersionClass()
    {
        InputStream resourceAsStream =
          this.getClass().getResourceAsStream(
            "/META-INF/maven/com.soebes.examples/version-examples-i/pom.properties"
          );
        this.prop = new Properties();
        try
        {
            this.prop.load( resourceAsStream );
        }
        ...
    }
}