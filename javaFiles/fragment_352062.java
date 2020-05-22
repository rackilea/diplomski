@Override
public boolean touchDown(int screenX, int screenY, int pointer, int button) {
for(int i=0; i<enemies.size; i++)
     if(enemies.get(i).getBounds().contains(screenX,screenY))
         enemies.removeIndex(i--); // if we touch an enemy remove it, we use i-- because we want to go back one, so we won't get the out of range exception if the last element in the array is touched!

 return false;
}