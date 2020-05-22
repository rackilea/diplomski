Gdx.gl.glViewport(0,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
batch.setProjectionMatrix(cam.combined);
batch.begin();        
batch.draw(img, 0, 0);
batch.end();

Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
batch.setProjectionMatrix(tmpM.set(cam.combined).scl(1, -1, 1));
batch.begin();        
batch.draw(img, 0, 0);
batch.end();

Gdx.gl.glViewport(Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
batch.setProjectionMatrix(tmpM.set(cam.combined).scl(-1, -1, 1));
batch.begin();        
batch.draw(img, 0, 0);
batch.end();

Gdx.gl.glViewport(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
batch.setProjectionMatrix(tmpM.set(cam.combined).scl(-1, -1, 1));
batch.begin();        
batch.draw(img, 0, 0);
batch.end();