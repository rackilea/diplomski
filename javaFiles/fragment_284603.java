public void onRequestStart(){
  showProgressBar(true);
}

public void onResponse(){
 //fetch your data
 //add your data to list or arrayList
 showProgressBar(false);
 setupRecycler(list);
}

public void setupRecycler(List<Object> response){
 YourRecyclerViewAdapter adapter = new YourRecyclerViewAdapter(response);
 recyclerView.setLayoutManager(...); // your layout manager
 recyclerView.setAdapter(adapter);
}