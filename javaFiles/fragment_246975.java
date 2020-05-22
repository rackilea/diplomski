class Square extends Rectangle{
        Square(){
           super(100, 100);
            setFill(Color.WHITE);
            setStroke(Color.BLACK);
            setOnMouseClicked(e -> {
                System.out.println(e.getButton().getClass());
                if(e.getButton().equals(MouseButton.PRIMARY)){
                    if(getFill() == Color.WHITE){
                        setFill(Color.BLUE);
                    }else {
                        setFill(Color.WHITE);
                    }
                }    
            });
        }
}