class MyPane extends Pane{
    private Background standard, other;

    public MyPane(){
        standard = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        other = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));
        this.setBackground(standard);
    }

    public void changeColor(){
        if(this.getBackground().equals(standard){
            this.setBackground(other);
        else{
            this.setBackground(standard);
        }
    }

    public void setBackground(Background bckgrnd){
        this.other = bckgrnd;
}