String sql = "SELECT * FROM table_name";

if (nameInput != null || surnameInput != null || genderInput != null)
{
    sql += " WHERE ";
}

if (nameInput != null)
{
    sql += "name=? ";
}