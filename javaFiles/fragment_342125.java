final int size = 500;
leftArrowBubble.setMaximumSize(new Dimension(size, size));
JLabel tac = new JLabel();
tac.setMaximumSize(new Dimension(size - 50, size - 50));
// [...]
tac.setText("<html><body style='width:" + (size - 150)
            + "px;padding:15px;display:block;'>"
            + textWithSeparators + "</body></html>");