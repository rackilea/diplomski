for(File directory : new File("numbers").listFiles()){
   File[] listOfFiles = directory.listFiles();
   for (File file : listOfFiles) {
        //println(file.getName());
        text = loadStrings(file);
        number = int(text);
        sortInteger(number);
   }
}