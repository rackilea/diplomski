public void draw(Batch batch, float alpha){
    batch.end();
    renderer.setProjectionMatrix(batch.getProjectionMatrix()); // <<<<< Add this
    renderer.begin(ShapeRenderer.ShapeType.Filled);
    renderer.setColor(Color.GREEN);
    renderer.rect(0, 0, 50, 50);
    renderer.end();
    batch.begin();
}