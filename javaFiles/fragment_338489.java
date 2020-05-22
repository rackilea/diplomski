public void deleteRowItem(RowItem row) {
    try {
        getHelper().getRowDao().delete(row);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}