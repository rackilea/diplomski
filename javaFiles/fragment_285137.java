public class GridBagLayoutDemo { // note code convention!

    int currentCard = 0;
    Action backAction, nextAction;
    ...

    public GridBagLayoutDemo() {
        ...
        backAction = new AbstractAction("< Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCard--;
                GridBagLayoutDemo.this.evaluateActions();
            }
        };

        nextAction = new AbstractAction("Next >") {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCard++;
                GridBagLayoutDemo.this.evaluateActions();
            }
        };

        JButton btnBack = new JButton(backAction);
        ...
        JButton btnNext = new JButton(nextAction);
        ...
    }

    private void evaluateActions() {
        backAction.setEnabled(currentCard > 0);
        nextAction.setEnabled(currentCard < container.getComponentCount() - 1);
    }
    ...
}