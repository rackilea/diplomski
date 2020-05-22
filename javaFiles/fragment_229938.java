public class Tab3 extends JPanel {

    JPanel Annex;
    Tab3Layout tab3Layout;

    public Tab3() {
        super();
        this.Annex = new JPanel();

        this.tab3Layout = new Tab3Layout(Annex);
        this.tab3Layout.createAnnex();

        this.setLayout(new BorderLayout());
        this.add(tab3Layout.getAnnex(), BorderLayout.WEST);
        this.add(new JPanel(), BorderLayout.EAST);
    }
}