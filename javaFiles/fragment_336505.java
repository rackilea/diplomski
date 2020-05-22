import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class BoardSteps {

    List<List<String>> boardList;

    @Given("^a board like this:$")
    public void a_board_like_this(DataTable dataTable) throws Throwable {
        boardList = convertDataTableToModifiableList(dataTable);
        System.out.println(boardList);
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        //throw new PendingException();
    }

    @When("^player x plays in row (\\d+), column (\\d+)$")
    public void player_x_plays_in_row_column(int row, int col) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //board.
        //throw new PendingException()
        boardList.get(row).set(col, "x");
    }

    @Then("^the board should look like this:$")
    public void the_board_should_look_like_this(DataTable expectedTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        expectedTable.diff(boardList);
        //throw new PendingException();
    }

    private List<List<String>> convertDataTableToModifiableList(DataTable dataTable){
        List<List<String>> lists = dataTable.asLists(String.class);
        List<List<String>> updateableLists = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++){
            List<String> list = lists.get(i);
            List<String> updateableList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++){
                updateableList.add(j, list.get(j));
            }
            updateableLists.add(i, updateableList);
        }
        return updateableLists;
    }

}