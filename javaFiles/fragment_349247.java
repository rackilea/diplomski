@Override
protected void onImpact(MovingObjectPosition mov) {
    LuckyPotionItems lpi = new LuckyPotionItems();
    EntityPlayer player = this.getThrower() instanceof EntityPlayer ? (EntityPlayer) this.getThrower() : null;
    if(mov.getBlockPos() != null && player != null) {
        if(!worldObj.isRemote)
        lpi.chooseUnluckyDrink(worldObj, player, mov.getBlockPos());
        this.setDead();
    }
}