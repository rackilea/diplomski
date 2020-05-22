public enum GameObjectType { Vehicle, Brick, ... };

public class GameObject
{
    GameObjectType Type;
    string Name;
    long ID; // I don't know if you need one
    Point Location;

    ...
}

public GameObject[,] Board;

Dictionary<GameObjectType, List<GameObject>> GameObjectsByType; // A mapping of all game objects by their type.