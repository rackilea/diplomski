//including the changes explained way above, where objectLayers is an 
//Array<LayerWrapper>, where LayerWrapper contains a zoom value and 
//an Array<Something>
for(int i=0;i<objectLayers.size;i++){
    LayerWrapper layer = objectLayers.get(i);
    Array<Something> layerObjects = layer.objects;

    camera.zoom = layer.zoom;
    camera.update();
    batch.setProjectionMatrix(camera.combined);

    //update the zoom level in the shader you're using with the sprite batch
    customShader.bind();
    customShader.setUniformf("u_zoom", layer.zoom);

    for(Something object : layerObjects ){
        object.sprite.draw(batch);
    }
}