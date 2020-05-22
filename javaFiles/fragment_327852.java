public void saveDataOnDevice(String toWrite, String filename) {
    try {
        FileOutputStream fos = this.openFileOutput(filename, Context.MODE_PRIVATE);
        //                     ^ --> refers to main class, in this case your MainActivity
        fos.write(toWrite.getBytes());
        fos.close();
    }
    catch (IOException ioe) {
        ioe.printStackTrace();
    }
}