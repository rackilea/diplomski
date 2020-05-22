JFileChooser chooser = new JFileChooser( new File(".") )
{
    public void approveSelection()
    {
        if (getSelectedFile().exists())
        {
            System.out.println("Do You Want to Overwrite File?");
            // Display JOptionPane here.  
            // if yes, super.approveSelection()
        }
        else
            super.approveSelection();
    }
};