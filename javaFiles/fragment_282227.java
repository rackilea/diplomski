String serfilename = "painitems.ser";

...

private ArrayList<HashMap<String, String>> loadListFromFile(
    ArrayList<HashMap<String, String>> masterlistrev) {
try {
    FileInputStream fis = openFileInput(serfilename);
    ObjectInputStream ois = new ObjectInputStream(fis);
    masterlistrev = (ArrayList<HashMap<String, String>>) ois.readObject();
} catch (Exception e) {
    e.printStackTrace();
}
return masterlistrev;
}

private void writeListToFile(ArrayList<HashMap<String, String>> masterlistrev){
    File myfile = getFileStreamPath(serfilename);
try {
    if(myfile.exists() || myfile.createNewFile()){
        FileOutputStream fos = openFileOutput(serfilename, MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(masterlistrev);
    }
} catch (Exception e) {
    e.printStackTrace();
}

}