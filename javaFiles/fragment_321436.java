if(!Gdx.input.justTouched()){
         sb.draw(shot[1], Gdx.graphics.getWidth() * 0.03f, Gdx.graphics.getHeight() * 0.03f, (Gdx.graphics.getWidth() * 1 / 6), (Gdx.graphics.getHeight() / 2) + (Gdx.graphics.getHeight() * 0.13f));
 }
 else{
       sb.draw((Texture) animation.getKeyFrame(timePassed,true), Gdx.graphics.getWidth() * 0.03f, Gdx.graphics.getHeight() * 0.03f, (Gdx.graphics.getWidth() * 1 / 6), (Gdx.graphics.getHeight() / 2) + (Gdx.graphics.getHeight() * 0.13f));
     }