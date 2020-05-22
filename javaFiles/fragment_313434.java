velocityY = 0;
accelerationY = -100;
public void generalUpdate(){
//ignore
BackX -= 1;
BackX2 -= 1;
//continue ignoring
if(BackX<=-480){
    BackX = 480;
}
if(BackX2<=-480){
    BackX2 = 480;
}
//this is the part we need

velocityY += accelerationY;
squiddyY  += velocityY;
if(Gdx.input.justTouched()){
    velocityY += 100;

}