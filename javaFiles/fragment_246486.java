private void getDataFromFile() {

FileInputStream fileInputStream = null;
try {
    fileInputStream = getContext().openFileInput("fileName");
} catch (FileNotFoundException e) {
    e.printStackTrace();
    return;
}
ObjectInputStream objectInputStream = null;
try {
    objectInputStream = new ObjectInputStream(fileInputStream);
} catch (IOException |NullPointerException e) {
    e.printStackTrace();
}
try {
    yourObject = (ObjectClass) objectInputStream.readObject();
} catch (IOException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
try {
    objectInputStream.close();
} catch (IOException e) {
    e.printStackTrace();
}

}