public class MyResultSet implements ResultSet{
private ResultSet orig;
public MyResultSet(ResultSet orig) {
    this.orig = orig;
}

// do delegations, 1000 methods like this
public String getString(int columnIndex) throws SQLException {
    return orig.getString(columnIndex);
}
// your own methods can come here
}