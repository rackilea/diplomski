lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
public void onItemClick(AdapterView<?> parent, View view, int position, long id) { 
    if (position == 0) {
        Intent myIntent = new Intent(view.getContext(), YourActivityName.class); 
         startActivityForResult(myIntent, 0); 
    } else if (position == 1) { 
        Intent myIntent = new Intent(view.getContext(), Youractivty2.class); 
       startActivityForResult(myIntent, 0); 
    } else if (position == 2) {
        Intent myIntent = new Intent(view.getContext(), YourActivity3.class); 
         startActivityForResult(myIntent, 0); 
     } else if (position == 3) { 
          Intent myIntent = new Intent(view.getContext(), YourActivity4.class); 
          startActivityForResult(myIntent, 0); 
      } 
  });