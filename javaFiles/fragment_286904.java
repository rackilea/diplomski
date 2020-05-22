ResultSet r = null;

try {
    ResultSet r = salesOrder.selectInAsending("soNo", "productionStatus = 'pending' and formatID='Zn-Al'", "soNo");

} catch (SQLException e) {

} finally {
    if (r != null) {
        try {
            r.close();
        } catch (SQLException e) {

        }
    }
}