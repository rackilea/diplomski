public void beginContact(Contact c) {
    System.out.println("CONTACT");

    WorldManifold worldmanifold;
    worldmanifold = c.getWorldManifold();

    for(Vec2 point : worldmanifold.points){
        System.out.println("Contact at : [" + point.x + ", " + point.y "]");
    }
}