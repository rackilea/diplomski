private JRadioButton createJRadioButton(int x){
    final JRadioButton rXStar = new JRadioButton();
    rXStar.setActionCommand(Integer.toString(x));
    return rXStar;
}

private ActionListener createActionListener(){
 return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                e.getActionCommand();
                 System.out.println(starGroup.getSelection().getActionCommand());
            }
        };
}