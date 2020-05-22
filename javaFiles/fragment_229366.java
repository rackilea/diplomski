@Given("^trades with the following details are created:$")
public void tradeWithTheFollowingDetailsAreCreated(DataTable dataTable) throws Exception {
    // transpose - transposes the table from the feature file
    // asList - creates a `List<Trade>`
    List<Trade> list = dataTable.transpose().asList(Trade.class);
    list.stream().forEach(System.out::println);
}