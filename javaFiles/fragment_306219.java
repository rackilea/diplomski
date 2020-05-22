dataList.setListData(loadModelFromDatabase());

public Vector loadModelFromDatabase() {
    Vector listModelData = new Vector();
    ResultSet res = conn.prepareStatement("SELECT * FROM listmodel").executeQuery();
    while(res.next()) {
       listModelData.add(res.getString(1));
    }

    return listModelData;
}