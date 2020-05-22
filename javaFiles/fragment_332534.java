private void doFill(double eventX, double eventY,boolean b){

    WritableImage i=pane.snapshot(new SnapshotParameters(), null);
    ArrayList<Integer> pozicie=new ArrayList<Integer>();
    ArrayList<Character> strany=new ArrayList<Character>();
    pozicie.add((int)eventX);
    pozicie.add((int)eventY);
    int c=i.getPixelReader().getColor((int)eventX,(int)eventY).hashCode();
    if(c==usedColor.hashCode()){
        //System.out.println("same color");

        return;}
    strany.add('a');


    while(pozicie.size()!=0){
        char strana=strany.remove(0);
        int x=pozicie.remove(0);
        int y=pozicie.remove(0);
        i.getPixelWriter().setColor(x, y, usedColor);
        if(strana=='d'){
            //iba dole
            if(y<pane.getHeight()-2 && i.getPixelReader().getColor(x, y+1).hashCode()==c){
                pozicie.add(x);
                pozicie.add(y+1);
                strany.add('d');
            }
        }
        else if(strana=='u'){
            //iba hore
            if( y>100 && i.getPixelReader().getColor(x, y-1).hashCode()==c){
                pozicie.add(x);
                pozicie.add(y-1);
                strany.add('u');
            }
        }
        else{


        if(x>2 && i.getPixelReader().getColor(x-1, y).hashCode()==c){
            pozicie.add(x-1);
            pozicie.add(y);
            strany.add('l');
        }
        if(x<pane.getWidth()-2 && i.getPixelReader().getColor(x+1, y).hashCode()==c){
            pozicie.add(x+1);
            pozicie.add(y);
            strany.add('r');
        }
        if( y>101 && i.getPixelReader().getColor(x, y-1).hashCode()==c){
            pozicie.add(x);
            pozicie.add(y-1);
            strany.add('u');
        }
        if(y<pane.getHeight()-2 && i.getPixelReader().getColor(x, y+1).hashCode()==c){
            pozicie.add(x);
            pozicie.add(y+1);
            strany.add('d');
        }
        }
    }
    pane.getChildren().clear();
    pane.getChildren().add(new ImageView(i));

}