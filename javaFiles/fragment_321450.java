tab3.removeAll();
for (int i = 0; i < listOfFiles.length; i++) {
    if (listOfFiles[i].isFile()) {
        JButton btnTemp2 = new JButton("Load: " + listOfFiles[i].getName());
        tab3.add(btnTemp2);
    }
}
tab3.revalidate();