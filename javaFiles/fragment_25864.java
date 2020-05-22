appState.getLat(i, new SnapshotListener{
  public void onListFilled(ArrayList<String> arrayLat){
    AdminActivity appState = new AdminActivity();
                    latString = arrayLat;
}
    public void onFailure(){
     //go crazy
}
});