float lastX, lastY;

if(sprite.getY()>=700){
  lastX = sprite.getX();
  lastY = sprite.getY();
  enemyIterator.remove();
  Pools.free(sprite);
}

System.out.println("Removed sprite coordinates where: " + lastX + ", " + lastY);