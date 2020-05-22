for (int i = 0; i < listOfFiles.length; i++) {
    if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
    } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
    }
    checkbox[i] = new JCheckBox(listOfFiles[i].getName());
}