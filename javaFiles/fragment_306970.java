class MyData {
    private String userName;
    private int userID;
    private int rowID;

    public MyData(String userName, int userID, int rowID) {
        this.userName = userName;
        this.userID = userID;
        this.rowID = rowID;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserID() {
        return userID;
    }

    public int getRowID() {
        return rowID;
    }
}