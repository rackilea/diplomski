counterTime += Gdx.graphics.getDeltaTime();
time += delta;
if(counterTime > 2f ) {// each second ==> one call to position random

    position = new Vector2(this.mari.x, this.mari.y);
    counterTime =0f;


}else { // between 2 seconds
    if(Gdx.input.isKeyPressed(Keys.B)) { // if "B" of Keyboard is pressed
        counterTime =3f; // go directly to the next random position

    }
}