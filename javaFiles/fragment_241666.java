@Override
public void render() {

   [...]

   // set viewport
   Gdx.gl.glViewport((int) _viewport.x, (int) _viewport.y,
            (int) _viewport.width, (int) _viewport.height);
   [...]
}