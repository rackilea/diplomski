final JTextComponent jtc = (JTextComponent)c;
jtc.requestFocus();
//jtc.selectAll();
SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        jtc.selectAll();
    }
});