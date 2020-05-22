public static void save(BufferedImage img, Frame frame) {

    //  Scanner scan = new Scanner(System.in);
    //  System.out.println("Enter the file name: ");
    //  String fileFullPath = scan.next();
        String fileFullPath = getFileToSaveTo(frame);
        file = new File(fileFullPath);
        saveToFile(img, file);

}