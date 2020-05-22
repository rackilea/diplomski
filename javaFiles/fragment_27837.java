animationFrames = new TextureRegion[2]; // having size 2 array initialisation not TextureRegion

for(int i = 0; i < 1; i++) {
     for(int j = 0; j < 1; j++) {
         animationFrames[index++] = frames[j][i]; //run once according to your condition
    }
}