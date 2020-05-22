while(iterMissiles.hasNext()){
  Missile m = iterMissiles.next();  //current Missile
  if(e.doesIntersect(m)){           
  //remove Enemy from enemiesLeft and add it to enemiesKilled list
  enemiesKilled.add(e);
  iterEnemies.remove();

  //remove Missile
  iterMissiles.remove();
  }
}