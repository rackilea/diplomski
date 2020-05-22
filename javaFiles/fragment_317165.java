public class FundTrf {

    @NotEmpty
    private String version;
    @Valid //ADDED VALID HERE
    private Data data;

    ..Getters and Setters
}