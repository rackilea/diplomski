FileInputStream fis = null;
try{
    fis = new FileInputStream(new File(enter.nextLine()));
    error = false;
} catch (FileNotFoundException e){
    // Blabla
}