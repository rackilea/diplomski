private void saveBike1LapActionPerformed(java.awt.event.ActionEvent evt) {                                             
    JFileChooser bike1FileChooser = new JFileChooser();
    int option = bike1FileChooser.showSaveDialog(TrackerWindow.this);
    if(option == JFileChooser.APPROVE_OPTION){
        String filename = bike1FileChooser.getSelectedFile().getName(); 
        String path = bike1FileChooser.getSelectedFile().getPath();
        int len = filename.length();
        String ext = "";
        String file;
        if(len > 4){
    ext = filename.substring(len-4, len);
        }
        if(ext.equals(".csv")){
        file = path; 
        }
        else{
        file = path + ".csv"; 
        }
        exportBikeLapTimes(bike1LapTimes, new File(file));
    }
}