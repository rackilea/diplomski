ObservableInt listVisibility = new ObservableInt(View.GONE);

public void setListData(List<Keyword> data) { 
   // update your list
   listVisibility.set( data.size() > 0 ? View.VISIBLE : View.GONE);
}