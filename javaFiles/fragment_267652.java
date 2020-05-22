@Override
public void draw(Batch batch, float parentAlpha) {
    batch.enableBlending(); //You can probably remove this line*
    Color color = getColor(); //keep reference to avoid multiple method calls
    batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
    batch.draw(texture, pos.x, pos.y);
}

/*    * It would only be useful if you have some custom Actors that disable blending. 
I don't think any of the built-in actors disable blending. Since many actors will 
require blending, it is usually best to leave it on even for fully opaque sprites, in 
order to avoid ending up with many draw calls. */