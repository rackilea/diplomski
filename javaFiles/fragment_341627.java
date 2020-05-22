public class ParameterAggregator {

    @QueryParam("nationality")
    @DefaultValue("nationality")
    private String nationality;

    @QueryParam("experience")
    @DefaultValue("experience")
    private String experience;

    @QueryParam("empid")
    @DefaultValue("empid")
    private String empid;

    // Getters and setters
}