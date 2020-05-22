listViewPeople.setOnItemClickListener(new ListView.OnItemClickListener() {
        @Override
    public void onItemClick(AdapterView<?> a, View v, int position, long l) {
             //IF YOU WANT TO CHANGE THE CONTENT OF THE ROW CLICKED
       if(position == someNumber) {
               text.set(position,"different Text");
               list1.setAdapter(text);
       }
    }
});