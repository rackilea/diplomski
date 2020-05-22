if(fromButton!=null){
 if (fromButton.equalsIgnoreCase("browseStoriesButton")) {
        i.putExtra("Button", "browseStoriesButton");
  } else {
        i.putExtra("Button", "notbrowseStoriesButton");
  }
 }else{
  i.putExtra("Button", "notbrowseStoriesButton");
}