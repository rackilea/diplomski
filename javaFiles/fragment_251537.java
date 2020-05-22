public class DungeonObject
{
public static final DungeonObject dirt = (new DungeonObjectDirt(0)).setName("#").setTexture("dirt");

...

public static DungeonObject[] objectList = new DungeonObject[16];

public DungeonObject (int id)
{
   if (objectList[id] != null)
    ....
}
}