private class StrListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button1)) {
            Timer t = new Timer(100, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    frame.repaint();
                }
            });
            t.start();
        }
    }
}