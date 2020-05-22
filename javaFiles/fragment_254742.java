try {
        //Files.move(fileToBeInstalled.toPath(), installPathFile.toPath(), REPLACE_EXISTING);
        Files.copy(fileToBeInstalled.toPath(), installPathFile.toPath(), REPLACE_EXISTING);
        fileToBeInstalled.delete();
} catch (IOException ex) {
    MainClass.getMainClass(InstallerLinux.class.getName()).log(Level.SEVERE, null, ex);

}