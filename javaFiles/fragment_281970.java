public class EnterItemInfo extends JFrame {
    private ItemFrame iFrame = new iFrame();
    ... all text fields and labels

    private JButton showBut = new JButton("show");

    public ItemFrame(){
        ... add components
        iFrame.setVisible(false);
        add(iFrame);

        add(showBut);
        showBut.addActionListener(new ActionListener(){
            iFrame.setVisible(true);
        });
    }

    private class ItemFrame extends JFrame {
        private JButton button = new JButton("show info");
        public ItemFrame(){
            add(new JLabel(), BorderLayout.CENTER);
            add(button, borderLayout.NORTH);

            button.addActionListener(new ActionListener(){
                ... do stuff
            });

        }
    }
}