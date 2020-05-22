public void stateChanged(ChangeEvent e)                     
{                                                           
   myPanel.setDiameter(diameterJSlider.getValue()); 
   stats = new JTextArea();  // *******??????????????????????**********
   radius = diameterJSlider.getValue() * .5;
   diameter = diameterJSlider.getValue();
   circumference = Math.PI * diameterJSlider.getValue();
   area = Math.PI * radius * radius;
   stats.setText("Radius: " + radius + " " + "Diameter: " + diameter + " " + "Circumference: " + circumference + " " + "Area: " + area); //help here
}