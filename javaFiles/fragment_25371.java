@ConfigurationProperties(prefix="tolerance")
public ToleranceProperties {

    @Range(min=1, max=100)
    private int percentage = 25; 

    // Here be a getter/setter
}