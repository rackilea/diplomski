@Override
public void start(Stage primaryStage) {

    primaryStage.setTitle("java-buddy.blogspot.com");
    Group root = new Group();

    TableColumn name = new TableColumn("name");
    name.setCellValueFactory(new PropertyValueFactory<Metrics, String>(
            "name"));

    TableColumn WMCCol = new TableColumn("WMC");
    WMCCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "WMC"));

    TableColumn DITCol = new TableColumn("DIT");
    DITCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "DIT"));

    TableColumn NOCCol = new TableColumn("NOC");
    NOCCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "NOC"));
    TableColumn CBOCol = new TableColumn("CBO");
    CBOCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "CBO"));
    TableColumn RFCCol = new TableColumn("RFC");
    RFCCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "RFC"));
    TableColumn LCOMCol = new TableColumn("LCOM");
    LCOMCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "LCOM"));
    TableColumn ceCol = new TableColumn("Ca");
    ceCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "ce"));
    TableColumn NPMCol = new TableColumn("NPM");
    NPMCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "NPM"));

    primaryStage.setScene(new Scene(root, 200, 200));
    primaryStage.show();

    List<Metrics> metric = readMetricFromCSV("C:\\Users\\pavi\\Desktop\\11.txt");
    // let's print all the metric read from CSV file
    for (Metrics m : metric) {
        System.out.println(m);

    }

    tableView.setItems(FXCollections.observableArrayList(metric));
    tableView.getColumns().addAll(name, WMCCol, DITCol, NOCCol, CBOCol,
            RFCCol, LCOMCol, ceCol, NPMCol);

    VBox vBox = new VBox();
    vBox.setMaxSize(600, 600);
    vBox.setSpacing(10);
    PieChart c = new PieChart();
    tableView.setOnMouseClicked(new EventHandler<Event>() {

        @Override
        public void handle(Event event) {
            c.setData(FXCollections.emptyObservableList());
            TableViewSelectionModel<Metrics> tableViewSelectionModel = tableView
                    .selectionModelProperty().get();
            Metrics m = tableViewSelectionModel.getSelectedItem();
            if(m==null){
                return;
            }
            ObservableList<PieChart.Data> pieChartData = FXCollections
                    .observableArrayList(
                            new PieChart.Data("CBO", m.getCBO()),
                            new PieChart.Data("Ce", m.getCe()),
                            new PieChart.Data("DIT", m.getDIT()),
                            new PieChart.Data("LCOM", m.getLCOM()),
                            new PieChart.Data("NOC", m.getNOC()),
                            new PieChart.Data("NPM", m.getNPM()),
                            new PieChart.Data("WMC", m.getWMC()));
            c.setData(pieChartData);
        }
    });
    vBox.getChildren().add(tableView);
    vBox.getChildren().add(c);

    root.getChildren().add(vBox);

}

public List<Metrics> readMetricFromCSV(String fileName) {

    List<Metrics> metricsss = new ArrayList<>();

    Path pathToFile = Paths.get(fileName);
    // create an instance of BufferedReader
    // using try with resource, Java 7 feature to close resources
    try (BufferedReader br = Files.newBufferedReader(pathToFile,
            StandardCharsets.US_ASCII)) {
        // read the first line from the text file
        String line = br.readLine();
        while (line != null && !line.isEmpty()) { // loop until all lines
                                                    // are read
            String[] attributes = line.split(" "); // the file, using a
                                                    // comma as the
                                                    // delimiter
            Metrics valueOfMetric = createMetric(attributes);
            metricsss.add(valueOfMetric); // adding metric into ArrayList
            // skip empty line
            // line.isEmpty() || line.trim().equals("") ||
            // line.trim().equals("\n"))
            br.readLine();
            line = br.readLine();
        }

    } catch (IOException ioe) {
        ioe.printStackTrace();
    }

    return metricsss;
}