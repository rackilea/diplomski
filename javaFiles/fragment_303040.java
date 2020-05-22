private TableView<StatisticsRemarkTableDto> statisticsTableView;

@FXML
private Pagination pagination ;

public void initialize() {

    statisticsTableView = new TableView<>();
    // create columns, etc...
    pagination.setPageFactory(this::createPage);
    // etc...
}