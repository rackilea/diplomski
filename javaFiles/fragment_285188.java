public JoinedObjects(int groupId){

    FixtureDef fdefa = new FixtureDef();
    fdefa.filter.categoryBits = 1;//category A
    fdefa.filter.maskBits = 0;//collide with nothing

    FixtureDef fdefb = new FixtureDef();
    fdefb.filter.categoryBits = 2;//category B
    fdefb.filter.maskBits = 0;//collide with nothing

    fdefa.filter.groupIndex = uniqueGroupId;//will collide with the rest of this group
    fdefb.filter.groupIndex = uniqueGroupId;//will collide with the rest of this group

    .....
}