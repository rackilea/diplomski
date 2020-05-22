long previousTime = 0;

public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
    long tmp = System.currentTimeMillis();
    long customDelta = tmp - previousTime;
    previousTime = tmp;

    Input input = gc.getInput();
    mousePosX = input.getMouseX();
    mousePosY = input.getMouseY();
    mouseLocationString = "Pointer location --- X:" +mousePosX+ " Y:" +mousePosY;

    for (int i=0; i<queuedParatroopers.size(); i++){
        if (queuedParatroopers.get(i).isReadyToDeploy(customDelta)){
            renderParatroopers.add(queuedParatroopers.get(i));
        }
    }

    //update the x and y of each paratrooper object.
    //Move() method accepts the delta and is calculated in to 
    //create a new x and y. Render method will update accordingly.
    if(renderParatroopers != null){
        for (Paratrooper1 para : renderParatroopers){
            para.Move(delta);
        }
    }
}