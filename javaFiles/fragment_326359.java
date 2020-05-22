public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source instanceof JButton) {
              JButton button = (button) source;

              JFrame ancestorWin = (JFrame) SwingUtilities.getAncestorWindow(button);
              ancestorWin.setUndecorated(!isFullScreen);
              ancestorWin.setResizable(isFullScreen);
              // etc...