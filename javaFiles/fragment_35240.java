listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     public void onItemClick(AdapterView<?> listView, View view, final int position, long id) {
          if(position < adapter.getCount()){ 
              Expenses expenses = (Expenses) adapter.getItem(position);
              String day = expenses.getDate();
          }
     }
 });