private String tableName;
private TableView<Model> table;

public Colonne(String tableName, TableView<Model> table) {
    this.tableName = tableName;
    this.table = table;
}

public void Apply() {
    try {
        Connection conn = Driver.connection();
        conn = DriverManager.getConnection("jdbc:mysql://"+Driver.getIP()+":"+Driver.getPort()+"/"+Driver.getDatabase()+"?autoReconnect="+Driver.getAutoReconnect()+"&useSSL="+Driver.getUseSSL()+"", 
                Driver.getUser(), Driver.getPassword());

        conn.createStatement();
        ResultSet rs = conn.getMetaData().getColumns(null, null, tableName, null);

        while(rs.next()) {
            if(!rs.getString("COLUMN_NAME").equals("NUMERO_AZIENDALE") && !rs.getString("COLUMN_NAME").equals("BOLO") && !rs.getString("COLUMN_NAME").equals("MARCHIO"))
                switch (rs.getString("TYPE_NAME")) {
                case "VARCHAR": 
                    TableColumn<Model, String> columnS = new TableColumn<Model, String>(rs.getString("COLUMN_NAME").replaceAll("_", " "));
                    if(!rs.getString("COLUMN_NAME").equalsIgnoreCase("STATO VISITA"))
                        columnS.setCellFactory(col -> new StringCell());
                    else
                        columnS.setCellFactory(col -> new ComboBoxCell());
                    table.getColumns().add(columnS); 
                    break;
                case "DATE": 
                    TableColumn<Model, LocalDate> columnD = new TableColumn<Model, LocalDate>(rs.getString("COLUMN_NAME").replaceAll("_", " "));
                    if(rs.getString("COLUMN_NAME").equalsIgnoreCase("DATA PREVISTA PARTO"))
                        columnD.setCellFactory(col -> new LocalDateDataPrevistaCell());
                    else 
                        columnD.setCellFactory(col -> new LocalDateCell());
                    table.getColumns().add(columnD); 
                    break;
                case "INT":
                    TableColumn<Model, Number> columnN = new TableColumn<Model, Number>(rs.getString("COLUMN_NAME").replaceAll("_", " "));
                    if(!rs.getString("COLUMN_NAME").contains("ID"))
                        columnN.setCellFactory(col -> new NumberCell());
                    table.getColumns().add(columnN);
                    break;
            }
        }

        conn.close();        

    } catch (SQLException e) {
        new FxDialogs().showException("Impossibile Trovare le Colonne", getClass().getSimpleName(), "1", e);
    }
}