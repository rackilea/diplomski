final List<String> colorList = new ArrayList<>();
colorList.add("blue");
colorList.add("green");

ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, colorList);
actv.setAdapter(adapter);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       String text = actv.getText().toString();
       int size = colorList.size();
        boolean exists = false;
       for(int i=0;i<size;i++){
           if(colorList.get(i).equals(text)){
              exists = true;
           } 
       }
       if(exists==false){
         colorList.add(text);
         ArrayAdapter newAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, colorList);
         actv.setAdapter(adapter);
       }
    }
});