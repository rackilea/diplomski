ImageIcon man;
ImageIcon grass;
public int xPosition=0;
public int yPosition=0;
public int oldX =0;
public int oldY = 0;

    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
        oldX = xPosition;
        oldY = yPosition;    
        if(evt.getActionCommand() == Actions.east.name()){
            System.out.println("east!");
            if(xPosition<4){
                xPosition++;
            }
            else{
                System.out.println("can't go east!");
            }
        }
        if(evt.getActionCommand() == Actions.west.name()){
            System.out.println("west!");
            if(xPosition>0){
                xPosition--;
            }
            else{
                System.out.println("can't go west!");
            }
        }
        if(evt.getActionCommand() == Actions.north.name()){
            System.out.println("north!");
            if(yPosition>0){
                yPosition--;
            }
            else{
                System.out.println("can't go north!");
            }
        }
        if(evt.getActionCommand() == Actions.south.name()){
            System.out.println("south!");
            if(yPosition<4){
                yPosition++;
            }
            else{
                System.out.println("can't go south!");
            }
        }
        URL imageMan = getClass().getResource("man.png");
        man= new ImageIcon(imageMan);

        URL imageGrass = getClass().getResource("grass.jpg");
        grass= new ImageIcon(imageGrass);

        points[oldX][oldY].setIcon(grass);
        points[xPosition][yPosition].setIcon(man);

        System.out.println("codinates: ("+xPosition+","+yPosition+")");
    }
}