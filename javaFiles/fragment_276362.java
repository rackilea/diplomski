File listnames = new File(this.getFilesDir() + File.separator + "Lists");
if( !listnames.exists() )
    listnames.mkdirs();
else if( !listnames.isDirectory() && listnames.canWrite() ){
    listnames.delete();
    listnames.mkdirs();
}
else{
    //you can't access there with write permission.
    //Try other way.
}