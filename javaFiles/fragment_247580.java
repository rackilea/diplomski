if (userWhoWantsToExtendDeadline == null || book == null || book.getbookID() == null {
    //throw exception perhaps or log?
    return false;
}

String query = "SELECT Deadline FROM library_students.borrowedcopies WHERE LenderToID = ? AND Barcode = ?";
Statement stmt = con.createStatement(query);

stmt.setInt(1, userWhoWantsToExtendDeadline.getId());
stmt.setString(2, book.getbookID());
ResultSet rs = stmt.executeQuery();