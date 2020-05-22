deleteButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent e){     
        // Don't know why you need to use invokeLater
        // The event should be trigged within the EDT if the user
        // clicked the button.  This may introduce a small "pause"
        // depending on what else is in the EDT...
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){ 
                // Get the indices of the selected rows...okay
                int[] selectedRow = jTable.getSelectedRows(); 
                // Loop through the selected rows...good...
                for(int j=0; j<selectedRow.length; j++){
                    // Get the "state" of the row...okay
                    Boolean state= (Boolean)jTable.getValueAt(selectedRow[j],10); 
                    // Long winded if, but okay...
                    if(state==true){//deleta the row
                        // Don't know what's going on here,
                        // But I assume you are trying to delete
                        // something from some kind of database
                        // THIS is likely to chew up some time...
                        User u=model.getUsers(selectedRow[j]);
                        new UserDao().delete(u);
                        // Uh oh...
                        // If you remove a row from the model, the list of indices you
                        // have is now invalid, as they no longer point
                        // to the correct rows in the model
                        model.remove(selectedRow[j]);
                        numberField.setText(String.valueOf(model.getRowCount()));
                    }
                }
            }
        });               
    }
});