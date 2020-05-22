public final class Tab3Layout {

    private JPanel Annex;
    JPanel Annex1; //just to avoid compiler error
    private GridBagLayout gridBagLayout;
    private GridBagConstraints co1;

    public Tab3Layout(JPanel Annex) {
        this.Annex = Annex;
        this.gridBagLayout = new GridBagLayout();
        this.co1 = new GridBagConstraints();
    }

    public void createAnnex() {
        this.Annex.setLayout(gridBagLayout);

        this.co1.gridx = 0;
        this.co1.gridy = 0;
        this.co1.anchor = GridBagConstraints.FIRST_LINE_START;
        this.co1.weighty = 1.0;

        this.Annex.add(Annex1, co1);
    }

    public JPanel getAnnex() {
        return this.Annex;
    }
}