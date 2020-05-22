private void saveDataToFile() {

FileOutputStream fileOutputStream = null;
try {
    fileOutputStream = getContext().openFileOutput("fileName", Context.MODE_PRIVATE);
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (NullPointerException e) {

}
ObjectOutputStream objectOutputStream = null;
try {
    objectOutputStream = new ObjectOutputStream(fileOutputStream);
} catch (IOException e) {
    e.printStackTrace();
} catch (NullPointerException e) {

}
try {
    if (objectOutputStream != null) {
        objectOutputStream.writeObject(yourObject); //which data u want to save
    }
} catch (IOException e) {
    e.printStackTrace();
}
try {
    if (objectOutputStream != null) {
        objectOutputStream.close();
    }
} catch (IOException e) {
    e.printStackTrace();
}