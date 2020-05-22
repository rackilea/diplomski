boolean collision = false;
for(int i = 0; i < rects.length; ++i){
    if(collision(rects[i]))
        collision = true;
}

if (collision == false)
    player.setY(player.getY() - 1f);