public Vector2 worldToCell(float x, float y) {
        float halfTileWidth = TILE_WIDTH * 0.5f;
        float halfTileHeight = TILE_HEIGHT * 0.5f;

        float row = (1.0f/2) * (x/halfTileWidth + y/halfTileHeight);
        float col = (1.0f/2) * (x/halfTileWidth - y/halfTileHeight);

        return  new Vector2((int)col,(int)row);
    }

    public Vector2 screenToWorld(float x, float y){
        Vector3 touch = new Vector3(x,y,0);
        cam.unproject(touch);
        touch.mul(invIsotransform);
        touch.mul(isoTransform);
        return  new Vector2(touch.x,touch.y);
    }


    public Vector2 screenToCell(float x, float y) {
        Vector2 world = screenToWorld(x,y);
        world.y -= TILE_HEIGHT *0.5f;
        return worldToCell(world.x,world.y);
    }