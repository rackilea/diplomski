@Override
public void onUpdate() {
    if((mc.thePlayer.moveForward != 0 || mc.thePlayer.moveStrafing != 0)
            && !mc.thePlayer.isSneaking() && mc.thePlayer.onGround) {
            mc.thePlayer.jump(); 
            mc.thePlayer.motionX *= 1.4;
            mc.thePlayer.motionY *= 0.4;
            mc.thePlayer.motionZ *= 1.4;
    }
}