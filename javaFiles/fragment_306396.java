} else if(i==2){
    System.out.println("ChoicePanel says i == "+i);
    model.setMessage(selection.getSelectedItem());
    //model.setCurrentShapeType(selection.getSelectedItem());
    model.resetComponents();
    ++i; // Increment here
 }