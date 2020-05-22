// Initially the cursor is positioned before the first row.
ResultSet resultSet = preparedStatement.executeQuery();

if  (resultSet != null && resultSet.next()) { // The cursor is moved to the first row
    while (resultSet.next()) { // The cursor is moved to the second row, so you skipped the
                               // first result and it only iterates from second to last one
        ...
    }
    postBundle = new PostBundle("200","SUCCESS!",posts); // posts only contains from
                                                         //second to last result. In case
                                                         //you only have one result,
                                                         //posts is an empty ArrayList

    return postBundle;
}