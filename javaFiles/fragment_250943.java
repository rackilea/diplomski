class MyGui
{
    private JButton jButton;
    private ActionListener mListener;

    public void createGUI(ActionListener oListener)
    {
        mListener = oListener;
        createGUIElements();
    }

    private createGUIElements()
    {
        jButton = new JButton();
        jButton.setText("MyButton");
        jButton.addActionListener(mListener);
     }
 }