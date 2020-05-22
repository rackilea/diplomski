public FrameForm extends JFrame {
    private PanelForm pForm = new PanelForm();

    public FrameForm() {
        initComponents();
        CardLayout card = new CardLayout();
        rightPanel.setLayout(card);

        rightPanel.add(pForm, "pForm");
    }
}