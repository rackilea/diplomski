List<DataModel> data = listFavoriteLocation();
for (int i = 0; i < data.size(); i++) {
    DataModel dataModel = data.get(i);
    log.i("Data model "+i+": "+dataModel);
    // Do work on each data model element here
}