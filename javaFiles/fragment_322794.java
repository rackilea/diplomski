public class Panel1 extends JPanel {

    public Panel1() {
        setLayout(new BorderLayout());

        //Set size of Panel1
        setBorder(BorderFactory.createLineBorder(Color.black));

        //Adding JTextArea and adding settings to it
        JTextArea storyLine = new JTextArea(20, 20);
        storyLine.setLineWrap(true);
        storyLine.setWrapStyleWord(true);
        storyLine.setEditable(false);

        //Adding JScrollPane to the JTextArea and making it have a vertical scrollbar
        JScrollPane scroll = new JScrollPane(storyLine);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scroll);
    }
}