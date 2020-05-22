public void onClick(View view) {
    model = new NameModel(NameList.get(position).getName());
    (...)
    CustomAdapter.nameArray.add(model);
    (...)
    CustomAdapter.nameArray.remove(model);
}