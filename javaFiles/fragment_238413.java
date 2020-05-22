void hit() {

    for(int i = 0; i < Bullet.size(); i++)
    {
        Bullet bul = (Bullet) Bullet.get(i);

        for(int j=0; j<enemies.size(); j++){
            Enemy enm = (Enemy)enemies.get(j);
            if(bul.x < enm.x + enm.l && bul.x > enm.x - enm.l && enm.y<bul.y)
            {
                enm.health -= 1;
                println("Hit");
                if(enm.health <= 0)
                {
                  enm = null;
                //  enemies.remove(i);
                }
            }  
        }
    }
}