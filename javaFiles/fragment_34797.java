List<MyObject> objs = new ArrayList<>();
ResultSet rs = stmt.executeQuery("Select * from Table");
while (rs.next()) {
    // construct obj from rs
    objs.add(myCreatedObj);
}

MyObject findFromObjs(final String id) {
    for (MyObject cool : objs) {
        if (cool.getId().equals(id)) return cool
    }
}