public void setListwriter(ArrayList<BetDisplayer> listwriter) {
    this.listwriter = new ArrayList<BetDisplayer>(listwriter);
    mPrefs.edit()
            .putString(MY_LIST, new Gson().toJson(listwriter));
            .commit();
}