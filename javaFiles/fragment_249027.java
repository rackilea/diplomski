public void onClick(View v){

 Intent intent=new Intent(v.getContext(),newActivityname.class);
 startActivityForResult(intent,0);

}