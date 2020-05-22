@Override
public void handle(MouseEvent me){
    if(rectangle.getFill() == standard){
        rectangle.setFill(other);
    }else{
        rectangle.setFill(standard);
    }