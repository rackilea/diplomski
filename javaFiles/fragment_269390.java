private void yourMethodWhereYouGetYourData(){
    //get your data
    ArrayList<String> masterCats = new ArrayList<String>();
    masterCats.add(cat);

   //Assuming you're doing this synchronously, once you've gotten your data just do:
   Intent i = new Intent(this, YourActivity.class);
   i.putStringArrayListExtra("MasterCats", masterCats);
   startActivity(i);
}