ArrayList<String> filesList = new ArrayList<String>();   
String sd_card = Environment.getExternalStorageDirectory().toString();
file = new File( sd_card ) ;       
File list[] = file.listFiles();
for( int i=0; i< list.length; i++) {
    filesList.add( list[i].getName() );
}