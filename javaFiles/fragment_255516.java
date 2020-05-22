box = new JFileChooser();
File selectedFile = null; // CHANGE 1

returnVal = box.showOpenDialog(null);
if (returnVal == box.APPROVE_OPTION) {
    selectedFile = box.getSelectedFile(); // CHANGE 2
}
try {
    BufferedReader br = new BufferedReader(new FileReader(selectedFile ));//CHANGE 5
    String line = "";
    while ((line=br.readLine()) != null) {//CHANGE 3
        System.out.println(line);//CHANGE 4
    }

    br.close();//@Tom comment:
} catch (Exception e1) {
    e1.printStackTrace();
}