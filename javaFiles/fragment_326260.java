// The old way
for (int i = 0; i < dm.size(); i++) {
    DataModel aDataModel = dm.get(i);
    String username = aDataModel.user;
    String password = aDataModel.password;
}

// A better way if java5+
for (DataModel aDataModel : dm) {
    String username = aDataModel.user;
    String password = aDataModel.password;
}

// another way if java8+
dm.forEach(aDataModel -> {
    String username = aDataModel.user;
    String password = aDataModel.password;
});