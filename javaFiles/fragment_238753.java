public static double getDistanceToEntity(Entity entity, BlockPos pos) {
    double deltaX = entity.posX - pos.getX();
    double deltaY = entity.posY - pos.getY();
    double deltaZ = entity.posZ - pos.getZ();

    return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
}