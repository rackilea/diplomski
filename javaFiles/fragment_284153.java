int mousex = Mouse.getX();
int mousey = Mouse.getY();
String buttonimgloc  = "unhoveredimagelocation.png"; 

public void render(GameContainer gc, StateBasedGame sbg, Graphics graphic) throws SlickException{
    Image button = new Image(buttonimgloc);
    graphic.drawImage(button, 35, 140);
}

public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
    Input input = gc.getInput();
    mousex = Mouse.getX();
    mousey = Mouse.getY();

    if((mousex>53 && mousex<114) && (mousey>300 && mousey<320)){
        buttonimgloc = "hoveredimagelocation.png";
        } else {
            buttonimgloc = "unhoveredimagelocation";
    }
}