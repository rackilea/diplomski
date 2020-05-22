enum SomeEnum{
        One, Two, Three;
    }

public static void main(String[] args){
    JFrame frame = new JFrame();
    JComboBox prePopulatedComboBox = new JComboBox(SomeEnum.values());
    prePopulatedComboBox.setSelectedIndex(-1);

    JComboBox postPopulatedComboBox = new JComboBox();
    postPopulatedComboBox.setSelectedIndex(-1);
    for(SomeEnum someEnum : SomeEnum.values()){
        postPopulatedComboBox.addItem(someEnum);
    }
    //Uncomment the below line to see the difference
    //postPopulatedComboBox.setSelectedIndex(-1);

    JPanel panel = new JPanel(new BorderLayout(5,5));
    panel.add(prePopulatedComboBox, BorderLayout.NORTH);
    panel.add(postPopulatedComboBox, BorderLayout.SOUTH);

    frame.add(panel);
    frame.setMinimumSize(new Dimension(250,250));
    frame.setVisible(true);
}