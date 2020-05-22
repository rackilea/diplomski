Object objectA=contact.getFixtureA().getUserData();
..
...
if(objectA instanceof Player){//instead of fb.getUserData().equals("player")
    ((Player) objectA)//Get object of class using casting
}