void beginContact(contact: Contact){

     switch (fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits) {
            case Game.WEAPON_BIT | Game.ENEMY_BIT: bodyDeleteList.add(contact.getFixtureA().getBody());
            System.out.println("Contact!");  // this prints
            break;
     }
}