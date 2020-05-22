String sqlUpdateforemp = "update emp_details set emp_name=? , emp_author = ? , emp_description = ? ,emp_description= ? ,  emp_thumbnail_name = ? ,emp_subscription=?";

    StringBuffer stringbuffer_sql = new StringBuffer(sqlUpdateforemp);
    int paramInd = 0;
    if (str_Preview_Pic != null && !str_Preview_Pic.isEmpty()) {
        stringbuffer_sql.append(",emp_preview_pic=?");
    }

    if (str_Thumb_Nail_Pic != null && !str_Thumb_Nail_Pic.isEmpty()) {
        stringbuffer_sql.append(",emp_thumbnail=?");
    }

    if (str_How_to_Video != null && !str_How_to_Video.isEmpty()) {
        stringbuffer_sql.append(",emp_video=?");
    }

    stringbuffer_sql.append("where emp_id=?");
    PreparedStatement Stmtupdateforemp = dbConnection.prepareStatement(stringbuffer_sql.toString());
    Stmtupdateforemp.setString(++paramInd,  % emp_name_VARIABLE %);
    Stmtupdateforemp.setString(++paramInd,  % emp_author_VARIABLE %);
    Stmtupdateforemp.setString(++paramInd,  % emp_description_VARIABLE %);
    Stmtupdateforemp.setString(++paramInd,  % emp_description_VARIABLE %);
    Stmtupdateforemp.setString(++paramInd,  % emp_thumbnail_name_VARIABLE %);
    Stmtupdateforemp.setString(++paramInd,  % emp_subscription_VARIABLE %);
    if (str_Preview_Pic != null && !str_Preview_Pic.isEmpty()) {
        Stmtupdateforemp.setString(++paramInd, str_Preview_Pic);
    }

    if (str_Thumb_Nail_Pic != null && !str_Thumb_Nail_Pic.isEmpty()) {
        Stmtupdateforemp.setString(++paramInd, str_Thumb_Nail_Pic);
    }

    if (str_How_to_Video != null && !str_How_to_Video.isEmpty()) {
        Stmtupdateforemp.setString(++paramInd, str_How_to_Video);
    }
    Stmtupdateforemp.setString(++paramInd,  % YOUR_EMPID_VARIABLE %);