lvItem.setOnItemClickListener(new OnItemClickListener() {  
    @Override  
    public void onItemClick(AdapterView<?> a, View v, int p, long id) {   
        HashMap<String,String> map = (HashMap) lvItem.getItemAtPosition(p);   
        ErrorMsg("ID:" + map.get("PK"));
     } 
});