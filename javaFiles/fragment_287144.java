public class Gui extends JFrame implements ListSelectionListener {

    Vector<String> menuList = new Vector<>();
    JList<String> menu = new JList<>(menuList);

    JPanel content = new JPanel(new CardLayout());

    Gui(){
        //put menu on left, content in middle
        add(menu, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);
        menu.addListSelectionListener(this);

        //add multiple cards
        addCard(new SimpleLabelCard("First Item", "First Item Text"));
        addCard(new SimpleLabelCard("Second Item", "Second Item Text"));
        addCard(new SimpleTextAreaCard("Third Item", "Third Item Text"));


        //set content to first item
        ((CardLayout) content.getLayout()).show(content, "First Item");
    }

    private void addCard(Card c){
        menuList.add(c.name);
        content.add(c, c.name);
    }


    public static void main(String [] args){
        Gui gui = new Gui();
        gui.setSize(600, 500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()) return;

        //set card layout from JList menu
        ((CardLayout) content.getLayout()).show(content, menu.getSelectedValue());
    }
}