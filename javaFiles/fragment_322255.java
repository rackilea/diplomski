private class GetButtonListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent ev) {
       grid.add(new JButton("Button 2")); //how to get this in the Grid ?
       grid.revalidate();
    }
}