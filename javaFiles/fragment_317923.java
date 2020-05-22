//inside the update method of your player
for(GameObject gameObject : world.getAllGameObjects()){             
            if(player.getHitbox().intersects(gameObject.hitbox())){
                gameObject.update() //push, update sprite, whatever
    }
}