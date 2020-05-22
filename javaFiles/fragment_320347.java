String query_to_update = "INSERT INTO `evidence_db`.`mcases` ("
                    + "`PID`,"
                    + " `FilePath`) "
                    + "VALUES (?,?);";

PreparedStatement pst=coneection.prepareStatement(query_to_update);
pst.setString(1,"DEFAULT");
pst.setString(2,pathField.getText());
pst.executeUpdate();