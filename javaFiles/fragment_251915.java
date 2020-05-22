/*
* adds an enemy and returns a reference to that enemy
*/
Spatial addEnemy()
{
    //Characters are spatials typically in JMonkey
    Spatial enemy=new Spatial(); 
    CapsuleCollisionShape collisionShape=new CapsuleCollisionShape(4.0f, 10.0f);
    CharacterControl characterControl = new CharacterControl(collisionShape, stepHeight);

    enemy.addControl(characterControl);
    getPhysicsSpaceState(characterControl);
    shootables.attachChild(enemy);
}