public void onClickSearch(View view) { 

    //String UPC = R.id.editText1.getText().toString(); 
    String UPC = mMyEditText.getText().toString();
    //Intent intent = new Intent("net.example.glutefree.Networking");   
    Intent intent = new Intent(this, YourOtherClass.class);
    intent.putExtra("UPCA", UPC);  //text is some key used to retrieve value in NextActivity 
    startActivity(intent);
}