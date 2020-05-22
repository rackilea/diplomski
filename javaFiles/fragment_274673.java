class DrawingPanel extends JPanel implements Observer{
    //Other attributes and initializations not shown
    @Override
    public void update(ArrayList<Integer> list){
        this.list = list;   //You can choose to receive element 
                            //indexs which got swapped instead (this is up to you)
        repaint();          //Repaint your current display when list is updated
    }

    //Register myself with the sorting algorithm class
    public void registerWith(Observable ob){
        if(ob != null)
            ob.register(this);
    }
}