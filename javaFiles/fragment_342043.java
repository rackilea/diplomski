private void sqlite() {
    sqlite.open();
    for(int i=0; i<deptTable.size(); i++) {
        sqlite.insert(deptTable.get(i).getName());
    }
    sqlite.close();
}