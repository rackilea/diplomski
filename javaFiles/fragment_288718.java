String title1 = "Tab 1";
String title2 = "Tab 2";

Component infoPanel1 = new FileInfoPanel();
Component infoPanel2 = new OtherInfoPanel();

Component content1 = new WaveFormPanel();
Component content2 = new OtherPanel();

final CardLayout infoLayout = new CardLayout();
final JComponent infoArea = new JPanel(infoLayout);
infoArea.add(infoPanel1, "1");
infoArea.add(infoPanel2, "2");

final CardLayout contentAreaLayout = new CardLayout();
final JComponent contentArea = new JPanel(contentAreaLayout);
contentArea.add(content1, "1");
contentArea.add(content2, "2");

class TabSwitcher
implements ActionListener {
    private String cardID;

    TabSwitcher(String cardID) {
        this.cardID = cardID;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        infoLayout.show(infoArea, cardID);
        contentAreaLayout.show(contentArea, cardID);
    }
}

JToggleButton tab1 = new JToggleButton("Tab 1");
tab1.setHorizontalAlignment(SwingConstants.LEADING);
tab1.addActionListener(new TabSwitcher("1"));

JToggleButton tab2 = new JToggleButton("Tab 2");
tab2.setHorizontalAlignment(SwingConstants.LEADING);
tab2.addActionListener(new TabSwitcher("2"));

ButtonGroup group = new ButtonGroup();
group.add(tab1);
group.add(tab2);

JComponent tabsPanel = new JPanel(new GridLayout(0, 1));
tabsPanel.setBorder(BorderFactory.createEmptyBorder(6, 0, 12, 0));
tabsPanel.add(tab1);
tabsPanel.add(tab2);

JComponent tabArea = new JPanel(new BorderLayout());
tabArea.add(tabsPanel, BorderLayout.PAGE_START);
tabArea.add(infoArea, BorderLayout.CENTER);

JComponent analyser = new JPanel(new BorderLayout());
analyser.add(tabArea, BorderLayout.LINE_START);
analyser.add(contentArea, BorderLayout.CENTER);

tab1.doClick();

frame.getContentPane().add(analyser);
frame.pack();