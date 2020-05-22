public class TableHandler {

    public Table getAwesomeTable()
    {        
        Table table = new Table();
        //.. do stuff with table

        //return table
        return table;
    }

    public static Table getTableWithoutInstancingThisClass()
    {
        Table table = new Table();
        //.. do stuff with table

        //return table
        return table;
    }

    public static void handMeTheStageToAlterIt(Stage stage)
    {
        //stage is passed as reference, 
        // as long as you don't give it a new Stage object you can alter it.
        stage.addActor(...);        
    }
}

public class MyScreen implements Screen {
    Stage stage;


    @Override
    public void show() {
        stage = new Stage();

        stage.addActor(TableHandler.getTableWithoutInstancingThisClass());

        TableHandler.handMeStageToAlterIt(stage);


        //instance tableHandler to get none static members.
        TableHandler tableHandler = new TableHandler();
        stage.addActor(tableHandler.getAwesomeTable());
    }

}