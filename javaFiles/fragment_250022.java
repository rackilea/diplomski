Action goLeft = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        cursx--;
        contentArea.remove(cursorlbl);
        cursorlbl = new JLabel("",cursor, JLabel.CENTER);
        contentArea.add(cursorlbl, Integer.toString(cursx) +" ," + Integer.toString(cursy));
        contentArea.revalidate();
        contentArea.repaint();
    }
};