private class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("Selected value = " +  e.getActionCommand());
    }
}