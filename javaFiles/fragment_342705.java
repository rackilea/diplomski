frameBuffer.begin();
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
batch.setProjectionMatrix(cam.combined);
batch.begin();        
batch.draw(img, 0, 0);
batch.end();
frameBuffer.end();

Texture fbTex = frameBuffer.getColorBufferTexture();
batch.getProjectionMatrix().idt();
batch.begin();
batch.draw(fbTex, -1, 1, 1, -1);
batch.draw(fbTex, -1, 0, 1, 1);
batch.draw(fbTex, 0, 0, 1, 1);
batch.draw(fbTex, 0, 1, 1, -1);
batch.end();