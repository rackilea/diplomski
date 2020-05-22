MigLayout layout;

public Constructor(){
   layout = new MigLayout();
   ...
   container.setLayout(layout);
}

public void onMouseDrag(JPanel panel, int newX, int newY){
   layout.setComponentConstraints(panel, "pos " + newX + " " + newY + ", w 100%/3, h 100%");
   container.validate(); // probably not necessary
}