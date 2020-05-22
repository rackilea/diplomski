final int totalNumber = 20;
final JCheckBox[] boxes = new JCheckBox[totalNumber ];
ActionListener myListener = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        Component c = (Component)e.getSource();
        for ( int i = 0; i < totalNumber; i++ ){
            if ( c == boxes[i] ){//this is the component that fired the event
                //do something
            }
        }
    } 
};
for ( int i = 0; i < totalNumber; i++ ){
    boxes[i] = new JCheckBox("Box " + i);
    boxes[i].addActionListener(myListener);
    parentContainer.add(boxes[i]);
}