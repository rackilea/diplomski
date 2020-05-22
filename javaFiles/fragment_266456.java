OnItemClickListener listener = new OnItemClickListener (){

  @Override
  onItemClick(AdapterView<?> parent, View view, int position, long id){
      String name = ((TextView) view.findViewById(R.id.txtText)).getText();
      Intent intent = new Intent(context,newActivityName.class);
      intent.putExtra("username",name);
      startActivity(intent);
  }

}