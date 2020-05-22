BlockPos playerPos = player.getPosition(); // Or some other method of getting a BlockPos of the player
positiveRadiusPosition = playerPos.add(radius, radius, radius); // Gets one corner of the cube in the positive X, Y, and Z direction
negativeRadiusPosition = playerPos.add(-1 * radius, -1 * radius, -1 * radius); // Gets the opposite corner

Iterable<BlockPos> cubeResult = BlockPos.getAllInBox(positiveRadiusPosition, negativeRadiusPosition);

for (BlockPos pos: cubeResult) {
  // cubeResult will contain blocks that are outside of the sphere with the 
  // radius you want. If that's okay, cool! If that's not okay, you should
  // check each pos' distance from the player. If it's outside of the radius,
  // remove it from the list.
}