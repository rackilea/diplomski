scrollBar=new JScrollPane(table);
scrollBar.getVerticalScrollBar().addAdjustmentListener(this);

public void adjustmentValueChanged(AdjustmentEvent e) {
    table.repaint();

    }