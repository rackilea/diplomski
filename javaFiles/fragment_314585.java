String prlQuery = "SELECT * FROM final_report WHERE used_PR LIKE ? OR create_PR LIKE ?";

    try {
        Date chooseDate = new Date(dateChooser.getDate().getTime());
        String parameter = "PR-L-" + selectMachine.getSelectedItem() + "-" + chooseDate;

        pst = connect.dbConnection().prepareStatement(prlQuery);
        pst.setString(1, parameter+"%");
        pst.setString(2, parameter+"%");