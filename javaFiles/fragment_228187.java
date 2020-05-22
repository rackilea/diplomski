private void prepareData() {
    ...
    if(listFile != null && listFile.length >= 0)
        mainList = new MainList("Photos",String.valueOf(listFile.length), R.drawable.phone);
    else
        mainList = new MainList("Photos", "0", R.drawable.phone);

    mainLists.add(mainList);
    ...
}