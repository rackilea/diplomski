targetMissileActive = new boolean [9];
  targetMissilePositionX = new int [9];
  targetMissilePositionY = new int [9];
  targetMissileDeltaX = new int [9];
  targetMissileDeltaY = new int [9];
  for (int i=0; i<9; i++) {
    targetMissilePositionX[i] = 0;
    targetMissilePositionY[i] = 0;
    targetMissileDeltaX[i] = 0;
    targetMissileDeltaY[i] = 0;
    targetMissileActive[i] = false;
}