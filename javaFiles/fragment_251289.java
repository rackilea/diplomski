UIManager.put("ToolTip.font", new Font("SansSerif",Font.PLAIN,25));

try
{
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
    {
        if ("Nimbus".equals(info.getName()))
        {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
}
catch (Exception e)
{
    // If Nimbus is not available, you can set the GUI to another look and feel.
}