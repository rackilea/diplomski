private static final int MAX_TURNS = 10;
    public void updateButtons(int turn) {
        for (Component c : letterPanel.getComponents()) {
          if (c instanceof JButton) c.setEnabled(turn <= MAX_TURNS);
        }
    }