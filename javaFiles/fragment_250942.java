class MyGui
{
    private JButton jButton;
    private MyButtonListener mListener;

    public void createGUI(MyButtonListener oListener)
    {
        mListener = oListener;
        createGUIElements();
    }

    private createGUIElements()
    {
        jButton = new JButton();
        jButton.setText("MyButton");
        jButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                mListener.onButtonClicked(e);             
            }
        });
     }
 }