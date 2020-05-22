if(pathChanged){
    System.out.println("PATH HAS CHANGED");
    System.out.println("NEW PATH IS   " + xPath);
    File fileStep1 = new File("C:\\ProgramManagement\\" + xPath + "\\step1");
    String[] directory1 = fileStep1.list(new FilenameFilter() {
        public boolean accept(File current, String name) {
            return new File(current, name).isFile();
        }
    });
    comboBox_1.removeAllItems();
    for (int i=0; i < directory1.length; i++ ){
        String sample = directory1[i];
        comboBox_1.addItem(sample);         
    }
    comboBox_1.setBounds(315, 189, 150, 25);
    MyFrame.getContentPane().add(comboBox_1);
}else{
    System.out.println("Path NOT changed");
    comboBox_1.setBounds(315, 189, 150, 25);
    MyFrame.getContentPane().add(comboBox_1);
}