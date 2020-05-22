private void jtext1ActionPerformed(java.awt.event.ActionEvent evt)
{
    // Your FileChooser code should live in a separate method. If the user
    // selects the FileChooser from a menu, then create an event handler for
    // that menu item. 
    try
    {
        FileReader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);

        String line = "";

        while((line = br.readLine()) != null)
        {
            // Do whatever you want with the line.
            // You can add it to an arraylist
            // or you can split() it into parts
            // or you can just print it to screen. Whatever.
        }
        br.close();
        // this line is probably unnecessary, but ultimately, not harmful
        jtext1.requestFocus();
    }
    catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}