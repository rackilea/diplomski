@Given("^Number parameter \\$(\\d+)$")
public void numberParameter(int number)
{
    System.out.println("Number from step is: " + number);
}

@And("^Text parameter \"([^\"]*)\"$")
public void textParameter(String text)
{
    System.out.println("Text from step is: " + text);
}

@And("^Table example$")
public void tableExample(DataTable table)
{
    List<List<String>> data = table.raw();
    // iterate through 'data' here to access rows in table
}