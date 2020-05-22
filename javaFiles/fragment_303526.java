boolean StringUsed = true;

changedComponents = new HashSet<Component>() {};
changedComponentNames = new HashSet<String>() {};

private void changeValueManyTimes() {
    long start = System.currentTimeMillis();

    for (int i = 0; i<count; i++) {
        recordStatisticsCheckBox.setSelected
            (!recordStatisticsCheckBox.isSelected());
    }
    long stop = System.currentTimeMillis();
    System.out.print("HashSet element type: " +
        (StringUsed ? "String" : "Object") + ", experiment count: " + count);
        System.out.println(", Elapsed time: " + (stop - start) + "ms");
        System.out.println("");
}

public static int count = 1000;      
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    StringUsed = false;
    changeValueManyTimes();
}                                        

private void recordStatisticsCheckBoxStateChanged     
    (javax.swing.event.ChangeEvent evt) {                                                      
    recordStatisticsCheckBoxActionPerformed(null);
}                                                     

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    StringUsed = true;
    changeValueManyTimes();        
}    

private void recordStatisticsCheckBoxActionPerformed 
    (java.awt.event.ActionEvent evt) {                                                         
    if (StringUsed) {
        if (recordStatisticsCheckBox.isSelected() == origSelection) {
            changedComponents.remove(recordStatisticsCheckBox);
        } else {
            changedComponents.add(recordStatisticsCheckBox);     
        }
        changeSaveEnabledIfNeeded();
    } else {
        if (recordStatisticsCheckBox.isSelected() == origSelection) {
           changedComponentNames.remove(recordStatisticsCheckBox.getName());
        } else {
           changedComponentNames.add(recordStatisticsCheckBox.getName());     
        }
        changeSaveEnabledIfNeeded();
    }
}

private void changeSaveEnabledIfNeeded() {
    if (changedComponents.size() == 0)
        saveButton.setEnabled(false);
    else
        saveButton.setEnabled(true);    
}