public void getNumberOfNames() {   
  while (this.inputStream.hasNext()) {   
     inputStream.nextLine(); // Need to read it so that we can go to next line if any
     fileDataRows++;    
  } 
}