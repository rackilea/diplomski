Gdx.gl.glClearColor(1f, 0.7f, 0.7f, 1f);
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

batch.setProjectionMatrix(camera.combined);
batch.begin();

tmpRenderArray.clear();
for(Renderable object : gameObjects)
    tmpRenderArray.add(object);

tmpRenderArray.sort(Renderable.PRIORITY_COMPARATOR); //invert this comparator
//PRIORITY_COMPARATOR = (b, a) -> Float.compare(b.getPriority(), a.getPriority());

for(Renderable renderable : tmpRenderArray)
    renderable.render();

batch.end();

//...