public class Tab3 extends JPanel {
JPanel Annex = new JPanel(); // <----- this, an empty JPanel
//A Bunch of Labels and Buttons

public Tab3(){
//ActionListeners for the Buttons
this.setLayout(new BorderLayout());
this.add(Annex,BorderLayout.WEST); // <----- is inserted here
this.add(Bsp,BorderLayout.EAST);
}}