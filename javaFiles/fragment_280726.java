@PropertySources({
        @PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:other.properties", ignoreResourceNotFound = true)
})
public class Application {
       ...
    }
}