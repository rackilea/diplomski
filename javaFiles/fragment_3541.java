//play around with this number
private static final float FFSpeed = 0.2f
@Override //probably
public boolean onTickInGame(float f, Minecraft minecraft){
    minecraft.thePlayer.speedOnGround=0.02f;
    return true; //tell it that this is handled
}