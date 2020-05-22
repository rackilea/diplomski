public ArrayList<BetDisplayer> getListwriter() {
    if (listwriter == null) {
       listwriter = new Gson().fromJson(mPrefs.getString(MY_LIST, null), LIST_TYPE);
       if(listwriter == null){
           listwriter = new ArrayList<BetDisplayer>();
       }
    }
    return listwriter;
}