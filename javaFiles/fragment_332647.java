for(int i=0;i<em.entities.size;i++){
    Entity e=em.engities.get(i);
    if (e instanceof Enemy) {
         if (getBounds().contains(e.getBounds())) {
                System.out.println("Collided!");
         }
    }
}