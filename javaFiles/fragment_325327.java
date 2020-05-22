for(i = 0; i < aliens.size(); i++){
    Aliens a = (Aliens) aliens.get(i);  // <-- This might be something you want to do
    if(hero.getBounds().intersects(a.getBounds())
        kill();
    else
        a.remove(i);
}