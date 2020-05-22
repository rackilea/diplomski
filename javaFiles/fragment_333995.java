public MutableLiveData<List<DWCategories>> getDWCategories(){
    setDWCategories(); // <- Remove this line!
    MutableLiveData<List<DWCategories>> data = new MutableLiveData<>();
    data.setValue(dataSet);

    return data;
}