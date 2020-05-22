if (i == 2)
{
    SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
               JOptionPane.showMessageDialog(null, "nope.");
        }
    });
}