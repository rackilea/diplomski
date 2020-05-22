//public ButtonGroup QuestionOneGroup()
public JPanel questionOneGroup()
{
    JRadioButton int1 = new JRadioButton("This is answer choice 1");
    JRadioButton ent1 = new JRadioButton("This is answer choice 2");
    JRadioButton jb1 = new JRadioButton("This is answer choice 3");
    ButtonGroup group = new ButtonGroup();
    group.add(int1);
    group.add(ent1);
    group.add(jb1);
    //return group;

    JPanel panel = new JPanel();
    panel.add( int1 );
    panel.add( ent1 );
    panel.add( jb1 );
    return panel;
}