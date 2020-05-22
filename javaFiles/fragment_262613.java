public static WorldVO create(JsonValue worldObject)
{
    WorldVO worldVO = new WorldVO();

    worldVO.id = worldObject.getInt("id");
    worldVO.unlock = worldObject.getInt("stars_to_unlock");

    JsonValue levels = worldObject.get("levels");
    int len = levels.size;
    worldVO.levelVOs = new LevelVO[len];
    for (int i = 0; i < len; i++)
    {
        worldVO.levelVOs[i] = LevelVO.create(levels.get(i));
    }