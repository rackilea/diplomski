boolean touched;
void draw(Batch batch)
    if(touched){
        batch.begin();
        font.draw(batch, "text", 200, 50);
        batch.end();
    }
}
@Override
public boolean touchDown(int screenX, int screenY, int      
pointer , int button) {
    super.touchDown(screenX, screenY, pointer, button);
    touched = true;
    return false;
}
@Override
public boolean touchUp(int screenX, int screenY, int      
pointer , int button) {
    super.touchUp(screenX, screenY, pointer, button);
    touched = false;
    return false;
}