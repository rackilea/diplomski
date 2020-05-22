public static void main(String [] args) {
    // look for the drive
    String drive = (new DetectDrive()).USBDetect();
    // if it found a drive (null or empty string says no)
    if(drive != null && !drive.isEmpty()) {
        // look for a file in that drive
        FileSearch fileSearch = new FileSearch();
        fileSearch.find(new File(drive+":"));
    }
}