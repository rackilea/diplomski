if(lkRatio.isSelected() !=true){
    tempw = width.getValue();
    templ = length.getValue();
    diff = width.getValue() - length.getValue();
}


if(lkRatio.isSelected()){

  if(source == width){
    length.setValue(width.getValue() - diff);
  }

  if(source == length){
       width.setValue(length.getValue() + diff);
  }
}