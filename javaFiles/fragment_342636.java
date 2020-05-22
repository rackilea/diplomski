public void setImage(){
   stringList.clear();
   String targetPath= 
    Environment.getExternalStorageDirectory().getAbsolutePath() + "/My Images/";
    File targetDirector = new File(targetPath);
    File[] files = targetDirector.listFiles();
Arrays.sort( files, new Comparator()
{
    public int compare(Object o1, Object o2) {

        if (((File)o1).lastModified() > ((File)o2).lastModified()) {
            return -1;
        } else if (((File)o1).lastModified() < ((File)o2).lastModified()) {
            return +1;
        } else {
            return 0;
        }
    }

});
for (File file : files){
    stringList.add(file.getAbsolutePath());
}

RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
rView.setHasFixedSize(true);
rView.setLayoutManager(layoutManager);
RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getApplicationContext(), stringList);
rView.setAdapter(rcAdapter);

}