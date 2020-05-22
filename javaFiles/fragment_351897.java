if  ( mc.objectMouseOver != null
   && mc.objectMouseOver.typeOfHit == MovingObjectType.ENTITY
   && mc.objectMouseOver.entityHit instanceof EntityLivingBase) {
    (new Thread() {
        public void run() {
            try {
                Thread.sleep(100);
                mc.thePlayer.swingItem();
                mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(mc.objectMouseOver.entityHit, C02PacketUseEntity.Action.ATTACK));
            } catch (InterruptedException ex) {
                return;
            }
        }
    }).start();
}