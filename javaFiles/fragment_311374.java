private void updateFilesName() {
    int j;
    for (int i = 1; i <= filesAmount; i++) {
        File file1 = new File(getFilesDir().getParent() + "/file_" + i + ".xml");
        if (!file1.exists()) {
            j = i+1;     
            while (!(new File(getFilesDir().getParent() + "/file_" + j + ".xml")).exists()) {
                j++; 
            }
            (new File(getFilesDir().getParent() + "/file_" + j + ".xml")).renameTo(file1);
        }
    }
}