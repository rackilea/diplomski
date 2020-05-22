import com.badlogic.gdx.math.MathUtils;

// ... define your class ...

private float spawnTime = 4f;
private float timer = 0;

// ...


public void update(float deltaTime) {
    // Increment timer by the duration since the previous frame
    timer += deltaTime;

    if (timer >= spawnTime) {
        this.spawnEntity();

        // the next spawn time will be triggered between 2 and 4 seconds :
        spawnTime = MathUtils.random(2f, 4f); 
        timer = 0;
    }
}



private void spawnEntity() {
    Texture floorTexture = game.getManager().get("floor.png");
    Texture overfloorTexture = game.getManager().get("overfloor.png");
    Texture overfloor2Texture = game.getManager().get("overfloor2.png");

    //Spawn your object
    floorList.add(new FloorEntity(world, floorTexture, overfloorTexture,overfloor2Texture, 0, 1000, 1));
    floorList.add(new FloorEntity(world, floorTexture, overfloorTexture,overfloor2Texture, 8, 10, 5));
    floorList.add(new FloorEntity(world, floorTexture, overfloorTexture,overfloor2Texture, 10, 10, 8));
    floorList.add(new FloorEntity(world, floorTexture, overfloorTexture,overfloor2Texture, 34, 3, 5));
    floorList.add(new FloorEntity(world, floorTexture, overfloorTexture,overfloor2Texture, 19, 8, 4));
    floorList.add(new FloorEntity(world, floorTexture, overfloorTexture,overfloor2Texture, 24, 8, 1.5f));
    floorList.add(new FloorEntity(world, floorTexture, overfloorTexture,overfloor2Texture, 27, 5, 2));
    obstacleList.add(new ObstacleEntity(world, floorTexture, overfloorTexture, overfloor2Texture, 25, 10 ,20));
}