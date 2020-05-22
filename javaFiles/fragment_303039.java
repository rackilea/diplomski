@FXML
private TableView<StatisticsRemarkTableDto> statisticsTableView;

@FXML
private Pagination pagination ;

public void initialize() {
    pagination.setPageFactory(this::createPage);
    // etc...
}