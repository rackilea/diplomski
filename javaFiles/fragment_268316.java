ArrayList<File> images = new ArrayList<>();
int selectedImageIndex =0;

public void selectFiles() {
    //you can call this method multiple times it wont matter
    //files selected at each time will be stored on the images arraylist
    JFileChooser chooser = new JFileChooser();
    chooser.setMultiSelectionEnabled(true);
    chooser.showOpenDialog(this);
    File[] files = chooser.getSelectedFiles();
    for (File file : files) {
        images.add(file);
    }
    startProgram(selectedImageIndex);
}

public void setImage(int index){

  if (index<images.size()) {
        File imageFile = images.get(index);
        selectedImageIndex = index;
        //read the file and set the image
   }else{
      System.out.println("no image found");
  }

}

public void goToNextImages(){
    ++selectedImageIndex;
    setImage(selectedImageIndex);
}

public void goToPreviousImage(){
    --selectedImageIndex;
    setImage(selectedImageIndex);
}

public void startProgram(int index){
    setImage(index);
}