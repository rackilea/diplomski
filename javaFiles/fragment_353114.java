public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    bottom.removeAll();
    if (source==a){
        bottom.add(aa);
        System.out.println("a was pressed");
    }
    else if (source==b){
        bottom.add(bb);
        System.out.println("b was pressed");
    }
    else{
        bottom.add(cc);
        System.out.println("c was pressed");
    }
    bottom.revalidate();
    bottom.repaint();
    this.setVisible(true);
}