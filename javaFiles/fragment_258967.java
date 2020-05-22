pig.timeChanged();    
if (keyboard.get(KeyCode.SPACE)) {
    pig.jumpBoost();
}    
// Note that pig.releaseLock() could be called in else 
// branch here and not in the onKeyReleased handler.
// Choose whatever solution suits you best.

// + draw image of the pig on pig.getX() and pig.getY() coordinates