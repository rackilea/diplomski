btnOne.setActionCommand("1");
 btnTwo.setActionCommand("2");

public void actionPerformed(ActionEvent e) {
 int action = Integer.parseInt(e.getActionCommand());

 switch(action) {
 case 1:
         //doSomething
         break;
 case 2: 
         // doSomething;
         break;
 }
}