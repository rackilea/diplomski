@FXML
    ObservableList GetTournamentsName() throws SQLException {

        ObservableList<String> optionList = FXCollections.observableArrayList();

        Connection con = DBconnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT Name FROM `tournaments`");
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            optionList.add(rs.getString("Name")));

        }

        con.close();
        return optionList;
    }