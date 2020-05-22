@Override
public void mousePressed(MouseEvent mEvt) {
   Component theCurrentPressedComponent = (Component) mEvt.getSource();

   // now you can use your variable above, although you probably need to 
   // cast it to something else, such as a JPanel

   // e.g., if it has been assigned a name String via setName(...)
   System.out.println(theCurrentPressedComponent.getName()); 
}