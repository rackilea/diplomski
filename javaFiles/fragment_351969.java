ArrayList<DataModel> dataModels = new ArrayList<DataModel>();

for (int i = 0; i < getResources().getStringArray(R.array.Name).length; i++) {
    dataModels.add(new DataModel(
            getResources().getStringArray(R.array.Name)[i],
            getResources().getStringArray(R.array.Version)[i],
            getResources().getStringArray(R.array.Id)[i],
            getResources().getStringArray(R.array.Date)[i]));
}