void display(){
    StateRenderer renderer = null ; // instantiate 
    Set<? extends State> states = null; // get your states here ( this is a mix of Puzzle and Queen states - but you dont care about the concrete type )
    for(StateDisplayable state : states){
        Image stateImage = state.getImage();  // this could be Puzzle or Queen stateImage
        renderer.draw(stateImage);
    }
}