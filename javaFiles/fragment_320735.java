public class MyActionListener
{
    private int proposition;
    private MyOtherClass moc;

    public MyActionListener(int proposition, MyOtherClass moc) {
        this.proposition = proposition;
        this.moc = moc;
    }

    public void actionPerformed(ActionEvent evt) {
        proposition += moc.action;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                moc.updatePropositionPanel();
            }
        });
    }
}