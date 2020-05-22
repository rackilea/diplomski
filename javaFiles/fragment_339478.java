String attendant = (String) cbName.getSelectedItem();
    String qry;
    if( attendant != null && !attendant.isEmpty() ) {
     qry = "SELECT id as 'No', recDate as 'Date', super as 'Supervisor', attendant as 'Attendant' from log"
            + "WHERE recDate = '"+dateString+"'"
            + "and attendant = '" + attendant + "'";
    } else {
        qry = "SELECT id as 'No', recDate as 'Date', super as 'Supervisor', attendant as 'Attendant' from log"
            + "WHERE recDate = '"+dateString+"'";
    }