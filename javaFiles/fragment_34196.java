public abstract class MyOwnActionListener implements ActionListener{
    @Override
    public void actionPerformed(final ActionEvent ae) {
        // own code
        doActionPerformed(ae); 
        // own code
    }

    protected abstract void doActionPerformed(ActionEvent ae);
}