// ADD Button.
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    Player player = new Player();

    // Player ID  
    String id = textPlayerID.getText();
    if (!id.equals("")) {
        // Make sure a numerical value was supplied.
        if (id.matches("\\d+")) {
            player.setID(Integer.parseInt(id);
        }
    }

    // Player First Name
    String firstName = textForename.getText();
    if (!firstName.equals("")) {
        player.setForename(firstName);
    }

    // Player Last Name
    String LastName = textSurname.getText();
    if (!lastName.equals("")) {
        player.setSurname(lastName);
    }


    // Player Date Of Birth
    String dob = textDOB.getText();
    if (!dob.equals("")) {
        // You should add code here to 'validate' the fact that
        // a valid date was supplied within the JTextField.

        // Format the date desired.
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        // Convert String date to a Date data Type. 
        Date dateOfBirth = formatter.parse(dob);
        player.setDOB(dateOfBirth);
    }

    // Player Position
    String position = textPosition.getText();
    if (!position.equals("")) {
        player.setPosition(position);
    }

    // Player Number  
    String number = textNumber.getText();
    if (!number.equals("")) {
        // Make sure a numerical value was supplied.
        if (id.matches("\\d+")) {
            player.setNumber(Integer.parseInt(number);
        }
    }

    // Player Team ID  
    String teamID = textTeamID.getText();
    if (!teamID.equals("")) {
        // Make sure a numerical value was supplied.
        if (id.matches("\\d+")) {
            player.setTeamID(Integer.parseInt(teamID);
        }
    }

    // Create and call a method to add the contents 
    // of the player object into database. If the
    // player already exists within the database then
    // use the UPDATE sql statement. If the player
    // does not exist within the databse then use the 
    // INSERT INTO sql statement.
    addToDatabase(player);
}