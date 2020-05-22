private class Animator implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        squares[0].y += 1;
        squares[1].y += 1;
        repaint();
    }
}